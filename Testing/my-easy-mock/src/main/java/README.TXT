EasyMock - convinient way to mock objects.

Annotations and Methods:
1. @RunWith(EasyMockRunner.class)
2. stockService = EasyMock.createMock(StockService.class); - creates a stub. Any call to method will throw RuntimeException
3. EasyMock.expect(stockService.getPrice(googleStock)).andReturn(50.0); - make implementation for particular case
4. EasyMock.replay(stockService); - activate the mock
5. @TestSubject - identify class which is going to use the mock object
6. @Mock - injection of mocked object (same to EasyMock.createMock)
7. EasyMock.verify(mock); -  tests whether mock was involved
8. Check on the number of calls that can be made on a particular method
        EasyMock.expectLastCall().times(1);        
       // EasyMock.expectLastCall().times(0, 1);
       // EasyMock.expectLastCall().atLeastOnce();
       // EasyMock.expectLastCall().anyTimes();
9. EasyMock.expect(personDaoMock.makeAction(40.0, 50.0)).andThrow(new NullPointerException()); - makes implementation hat throws Exception for particular case
10.EasyMock.createNiceMock(mock); - mock with default implementation
11. class EasyMockSupportExample extends EasyMockSupport:
    Provides additional features:
    gives 3 methods:
    replayAll() – Registers all the created mocks in one batch.
    verifyAll() – Verifies all the mock operations in one batch.
    resetAll() – Resets all the mock operations in one batch.    

    
        
        
        
