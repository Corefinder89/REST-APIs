package com.expose.restapi;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/testapp")
public class MyApplication extends Application
{
	@Override
    public Set<Class<?>> getClasses() 
	{
        Set<Class<?>> set = new HashSet<>();
        set.add(CtoFService.class);
        set.add(FtoCService.class);
        return set;
    }
}