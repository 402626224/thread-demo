package com.tuandai.thread.mockbase;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;


/**
 * Created by liusongrui on 2019/1/22.
 */
public class MockBaseTest {

    /**
     * @throws Exception
     */
    @Test
    public void testMockList() throws Exception {
        // create
        List mockedList = Mockito.mock(List.class);

        // using mock object
        mockedList.add("aaa");
        mockedList.add("bbbb");
        mockedList.clear();

        // verify
        Mockito.verify(mockedList).add("aaa");
        Mockito.verify(mockedList).add("bbbb");
        Mockito.verify(mockedList).clear();
        Mockito.verify(mockedList).add("bbbb");
        Mockito.verify(mockedList).add("bbbb");
        Mockito.verify(mockedList).add("bbbb");

    }

}