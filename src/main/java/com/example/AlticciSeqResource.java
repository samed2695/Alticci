package com.example;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/alticci/{n}")
public class AlticciSeqResource {
    private List<Integer> longestAlticciSeq = new ArrayList<>(){{
        add(0);add(1);add(1);
    }};

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public  List<Integer>  getAlticciSequence(@PathParam("n") int n) {
        if(n > longestAlticciSeq.size()-1) {
            longestAlticciSeq.addAll(getAlticciSeqWithInitialIndex(longestAlticciSeq.size(),n));
            return longestAlticciSeq;
        }
        return longestAlticciSeq.subList(0,n);
    }
    private List<Integer> getAlticciSeqWithInitialIndex(int initInd,int n){
        List<Integer> ret = new ArrayList<>();
        for(int i=initInd;i<=n;i++){
            ret.add(longestAlticciSeq.get(i-3),longestAlticciSeq.get(i-2));
        }
        return ret;
    }
}