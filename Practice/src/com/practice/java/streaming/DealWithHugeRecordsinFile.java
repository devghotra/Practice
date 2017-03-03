package com.practice.java.streaming;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Naresh Bhabat
 * 
Following  implementation helps to deal with extra large files in java.
This program is tested for dealing with 2GB input file.
There are some points where extra logic can be added in future.


Pleasenote: if we want to deal with binary input file, then instead of reading line,we need to read bytes from read file object.



It uses random access file,which is almost like streaming API.


 * ****************************************
Notes regarding executor framework and its readings.
Please note :ExecutorService executor = Executors.newFixedThreadPool(10);

 *  	   for 10 threads:Total time required for reading and writing the text in
 *         :seconds 349.317
 * 
 *         For 100:Total time required for reading the text and writing   : seconds 464.042
 * 
 *         For 1000 : Total time required for reading and writing text :466.538 
 *         For 10000  Total time required for reading and writing in seconds 479.701
 *
 * 
 */
public class DealWithHugeRecordsinFile {//extends TestCase {

	static final String FILEPATH = "/Users/desingh/Desktop/sample-input";
	static final String FILEPATH_WRITE = "/Users/desingh/Desktop/book1.txt";
	static RandomAccessFile fileToWrite;
	static RandomAccessFile file;
	//static volatile String fileContentsIter;
	static int position = 0;
	
	static AtomicInteger readIndex = new AtomicInteger(0);
	static AtomicInteger writeIndex = new AtomicInteger(0);
	static int offset = 1000;
	static BlockingQueue<FileChunk> blockQ;
	static boolean fileReadComplete = false;
	static boolean fileWriteComplete = false;
	static Integer semaphore = 0;
	
	private static int getReadIndex(){
		return readIndex.getAndAdd(offset);
	}
	
	private static int updateWriteIndex(){
		return writeIndex.getAndAdd(offset);
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		long currentTimeMillis = System.currentTimeMillis();

		try {
			blockQ = new ArrayBlockingQueue<>(3);
			fileToWrite = new RandomAccessFile(FILEPATH_WRITE, "rw");//for random write,independent of thread obstacles 
			file = new RandomAccessFile(FILEPATH, "r");//for random read,independent of thread obstacles 
			seriouslyReadProcessAndWriteAsynch();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread.getName());
		long currentTimeMillis2 = System.currentTimeMillis();
		double time_seconds = (currentTimeMillis2 - currentTimeMillis) / 1000.0;
		System.out.println("Total time required for reading the text in seconds " + time_seconds);

	}

	/**
	 * @throws IOException
	 * Something  asynchronously serious
	 * @throws InterruptedException 
	 */
	public static void seriouslyReadProcessAndWriteAsynch() throws IOException, InterruptedException {
		ExecutorService readerExecutor = Executors.newFixedThreadPool(1);//pls see for explanation in comments section of the class
		ExecutorService writeExecutor = Executors.newFixedThreadPool(1);
		
		readerExecutor.execute(new ReaderTask());
		//readerExecutor.execute(new ReaderTask());
		//readerExecutor.execute(new ReaderTask());
		
		
		writeExecutor.execute(new WriterTask());
		//writeExecutor.execute(new WriterTask());
		//writeExecutor.execute(new WriterTask());
		
		
		readerExecutor.shutdown();
		writeExecutor.shutdown();
		
		while(!readerExecutor.isTerminated() || !writeExecutor.isTerminated()){
			Thread.sleep(1000);
		}
		file.close();
		fileToWrite.close();
		
		System.out.println("Finished all threads");
	}
	
	static class ReaderTask implements Runnable{
		
		public void run() {
			while(!fileReadComplete){
				int readIndex = getReadIndex();
				byte[] b = new byte[offset];
				try {
					file.read(b);
					//System.out.println("Reader Running - "+Thread.currentThread().getName()+" offset "+readIndex);
					if(b.length < offset)
						fileReadComplete = true;
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					blockQ.put(new FileChunk(b, readIndex));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Reader finished - "+Thread.currentThread().getName()+" offset "+readIndex);
			}
			System.out.println("Reader ended");
		}
	}
	
	static class WriterTask implements Runnable{
		public void run() {
			
			try {
				while(!fileWriteComplete){
					try {

						if(fileReadComplete && readIndex.intValue() == writeIndex.intValue())
							fileWriteComplete = true;
						
						FileChunk chunk = blockQ.take();

						if(chunk.offset == writeIndex.intValue()){
							try {
								//System.out.println("Writer Writing - "+Thread.currentThread().getName()+" offset "+chunk.offset);
								fileToWrite.write(chunk.b);
								updateWriteIndex();
								//break;
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else{
							//System.out.println("Writer Sleeping - "+Thread.currentThread().getName()+" offset "+chunk.offset);
							//Thread.sleep(1000);
						}
					
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("WriterTask ended");
		}
	}
	
	static class FileChunk implements Comparable<FileChunk>{
		byte[] b;
		int offset;
		
		public FileChunk(byte[] b, int offset){
			this.b = b;
			this.offset = offset;
		}

		@Override
		public int compareTo(FileChunk o) {
			if(this.offset < o.offset)
				return -1;
			else if(this.offset > o.offset)
				return 1;
			else 
				return 0;
		}
	}
	
}