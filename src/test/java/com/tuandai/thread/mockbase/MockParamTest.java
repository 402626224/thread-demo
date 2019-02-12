package com.tuandai.thread.mockbase;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by liusongrui on 2019/1/22.
 */
public class MockParamTest {

    /**
     * @throws Exception
     */
    @Test
    public void testMockParam() throws Exception {

        List mockedList = mock(LinkedList.class);

        when(mockedList.get(anyInt())).thenReturn("element");
//      when(mockedList.contains(argThat(isValid()))).thenReturn("element");

        System.out.println(mockedList.get(999));

        verify(mockedList).get(anyInt());


    }


}
