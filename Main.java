import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main 
{	
     public static void main(String[] args) 
     {
	Queue q = null;
	try{
		q = parseToQueue("customers.dat");
	}catch(IOException e)
	{
		System.out.println("Error finding or reading file.");
		System.exit(-1);
	}

	int totalWaitTime = 0;
	int nextAvailTimeA= 0;
	int nextAvailTimeB= 0;
     
	while (!q.isEmpty()) {
	     
          CustomerRecord customer = (CustomerRecord) q.dequeue();
	     
	     int waitTime = 0;

	     if(nextAvailTimeA <= nextAvailTimeB) {
               if (nextAvailTimeA > customer.getArrivalTime()) {
                    waitTime += nextAvailTimeA - customer.getArrivalTime();
               }
               nextAvailTimeA = customer.getArrivalTime() + waitTime + customer.getHelpTime();
	     } else {
		     if (nextAvailTimeB > customer.getArrivalTime()) {
                    waitTime += nextAvailTimeB - customer.getArrivalTime();
               }
               nextAvailTimeB = customer.getArrivalTime() + waitTime + customer.getHelpTime();
          }     
          totalWaitTime += waitTime;
          System.out.println(totalWaitTime);
     }
     
     }

     public static Queue parseToQueue(String fileName) throws NumberFormatException, 
                                                              IOException 
     {
        Queue queue = new CustomerQueue();
        File file = new File(fileName); 
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        String line; 
        String[] splitRecord;
        while ((line = br.readLine()) != null) 
        {
           splitRecord = line.split(" ");
           queue.enqueue(new CustomerRecord(Integer.parseInt(splitRecord[0]), 
                                            Integer.parseInt(splitRecord[1])));
        } 
        br.close();
        return queue;
      }
}
