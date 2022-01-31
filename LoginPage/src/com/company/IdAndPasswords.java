package com.company;

import java.util.HashMap;

    class IdAndPasswords {

    private HashMap<String, String> loginInfo;

    IdAndPasswords(){
        loginInfo = new HashMap<>();

        loginInfo.put("Hey","abc123");
        loginInfo.put("user","password123");
        loginInfo.put("Coper","seetheBitch");
    }

    protected HashMap getInfo(){
        return loginInfo;
    }
}
