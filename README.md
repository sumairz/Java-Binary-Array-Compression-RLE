I made this algorithm based on the concept of run length encoding compression for my advance database project where we had to make binary index where 1s are the actual line number in a very big data file.

The good thing is that after compression of the binary index we can query the compressed data to get line numbers you do not need to decompress for query.

We achieved around 75% of compression compared with binary index file.

I haven't tested this algorithm in many cases so I can say it just fulfilled my need for the assignment but anyone can try and welcome to improve the algorithm
