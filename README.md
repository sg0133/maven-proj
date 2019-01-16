Java implementation of http://agilekatas.co.uk/katas/BerlinClock-Kata


Please make sure you have java 8 installed.

To quickly test functionality please refer to BerlinClockTest class.
It uses TestHelper class's TEST_CASE_POOL array with multiple test cases,
so you may add more cases if you would like.

There is also load test in BerlinClockLoadTest class which tests
BerlinClockImpl.displayTime method under concurrent load.
It creates 100 threads, waits until all threads are submitted,
then runs them concurrently and saves expectedOutput and actualOutput
in a tuple. Once all threads has finished, it then asserts that all
result are correct by going through the list returned by each thread.

Have fun.

K.A

