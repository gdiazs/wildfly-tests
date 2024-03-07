package com.github.gdiazs.rest.services;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class ScopedService
{

    public boolean isThisMethodWorking(){
        return true;
    }
}
