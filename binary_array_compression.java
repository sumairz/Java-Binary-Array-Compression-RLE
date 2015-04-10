/*
I made this algorithm based on the concept of run length encoding compression for my advance database project where we had to make binary index where 1s are the actual line number in a very big data file.

The good thing is that after compression of the binary index we can query the compressed data to get line numbers you do not need to decompress for query.

We achieved around 75% of compression compared with binary index file.

I haven't tested this algorithm in many cases so I can say it just fulfilled my need for the assignment but anyone can try and welcome to improve the algorithm

*/

public class Array_Compression {
    
    static int[] num = {0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0};
    static String compNum = "8:1:10:1:3:1:10:1:3:1:5:1:5:1:2:";
    static String finalData = "";
    
    public void compressArray(int[] num)
    {        
        int zeroCount = 0;
        boolean zeroCheck = false;
         
            for(int i=0;i<num.length;i++)
            {   
                    if(num[i] == 1)
                    {
                        if(zeroCheck == true)
                        {
                            if(zeroCount == 1)
                                finalData = finalData + 0 + ":";
                            else
                                finalData = finalData + zeroCount + ":";
                           zeroCount = 0;
                           zeroCheck = false;
                        }
                        finalData = finalData + num[i] + ":";               
                    }            
                    else
                    {
                        zeroCount++;
                        zeroCheck = true;
                    }
                
            }
            finalData = finalData + zeroCount + ":";
            System.out.println(finalData);
            finalData = "";
            zeroCount = 0;
            zeroCheck = false;            
        }
    
    public void decompressArray()
    {
        String[] parts = compNum.split(":");
        String tempResult = "";
        
        for(int i=0;i<parts.length;i++)
        {
            int tempInt = Integer.parseInt(parts[i]);
            if(tempInt == 1)
            {
                tempResult = tempResult + tempInt;
            }
            else
            {
                for(int k=0;k<tempInt;k++)
                {
                    tempResult = tempResult + 0;
                }
            }            
        }
        System.out.println(tempResult);
    }
    
    public void getLineNumber()
    {
        // 0:1:0:1:3:1:2:
        String[] parts = compNum.split(":");          
        int sum = 0;
        
        for(int i=0;i<parts.length;i++)
        {
            int tempInt = Integer.parseInt(parts[i]);
            int oneCheck = Integer.parseInt(parts[i]);
            
            if(tempInt == 0)
                tempInt = 1;
            
            sum = sum + tempInt;
            
            if(oneCheck == 1)
                System.out.println(sum);
        }
    }
    
    public static void main(String[] args)
    {
        
    }
}
