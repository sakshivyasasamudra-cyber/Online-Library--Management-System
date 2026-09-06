## Design Limitation

While designing the system, I identified a limitation in the current implementation. 
The Producer-Consumer model works well for coordinating library operations
however, as I was a beginner learning the Producer-Consumer concept in Java,
my initial implementation used a single shared instance to manage the borrowing process.
This design limits the system's ability to handle multiple book-borrowing operations independently.

The problem statement highlighted that only 3 books can be issued,but
as this is an Online Library Management System to meet the real world expectation,
we further raise it to have multiple instances
to increase issue, return of a book.
Identifying this limitation helped me better understand the importance of designing
shared resources carefully in concurrent systems. 
In a future version, the implementation can be improved to support multiple borrowing operations
while maintaining proper synchronization and thread safety.
