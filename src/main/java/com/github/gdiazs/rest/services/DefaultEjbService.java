package com.github.gdiazs.rest.services;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

@Startup
@Singleton
public class DefaultEjbService
{
    private final static Logger LOGGER = Logger.getLogger( DefaultEjbService.class.getName() );

    @Inject
    private ScopedService scopedService;

    @PostConstruct
    public void simulatedListener()
    {
        //Java SE executor service is JDK level. ManagedExecutorService should be used as long is managed by the Jakarta EE CDI container, in this case Wildfly
        final ExecutorService executorService = Executors.newFixedThreadPool( 10 );
        while ( true )
        {
            threadDetails();
            executorService.execute( () -> {
                //Dangerous code, out of scope
                threadDetails();
                boolean result = scopedService.isThisMethodWorking();
                LOGGER.log( Level.INFO, "was method invoked?: %s", result);

            });

        }
    }

    private static void threadDetails()
    {
        try
        {
            Thread.sleep( 1000 );
            Thread currentThread = Thread.currentThread();
            LOGGER.log( Level.INFO, String.format( "Thread name= %s", currentThread.getName()));
        }
        catch ( InterruptedException e )
        {
            LOGGER.log( Level.SEVERE, "Ups", e );
        }

    }

}
