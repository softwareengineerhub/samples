/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutorialspoint.ch01;

import org.tutorialspoint.ch01.Stock;
import org.tutorialspoint.ch01.Portfolio;
import org.tutorialspoint.ch01.StockService;
import java.util.ArrayList;
import java.util.List;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author prokopiukd
 */
public class PortfolioTest {
    private Portfolio portfolio;
    private StockService stockService;
    
    @Before
    public void setUp(){
        portfolio = new Portfolio();
        stockService = EasyMock.createMock(StockService.class);
        portfolio.setStockService(stockService);
    }
   
    @Test
    public void test(){
        List<Stock> stocks = new ArrayList<>();
        Stock googleStock = new Stock("1", "Google", 10);
        Stock microsoftStock = new Stock("2", "Microsoft", 100);
        
        stocks.add(googleStock);
        stocks.add(microsoftStock);
        
        portfolio.setStocks(stocks);
        EasyMock.expect(stockService.getPrice(googleStock)).andReturn(50.0);
        EasyMock.expect(stockService.getPrice(microsoftStock)).andReturn(1000.0);
        
        //activate the mock
        EasyMock.replay(stockService);
        
        double marketValue = portfolio.getMarketValue();
        Assert.assertTrue(marketValue == 100500.0);
        
    }
    
}
