package com.example.user_management.dao.generator;

import org.hibernate.id.IdentifierGenerator;
import org.hibernate.engine.spi.SharedSessionContractImplementor;


import java.io.Serializable;
import java.util.UUID;

public class IdGenerator implements IdentifierGenerator{
    @Override
    public Serializable generate(SharedSessionContractImplementor session,Object object){
        return UUID.randomUUID().toString().replace("-","");
    }
}
