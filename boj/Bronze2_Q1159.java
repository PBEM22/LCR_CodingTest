package boj;

import java.util.*;
import java.io.*;

public class Bronze2_Q1159{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        Set<String> first = new HashSet<>();
        String[] nameList = new String[N];        
        StringBuilder sb = new StringBuilder();
        int allCount = 0;
        
        for(int i = 0; i < N; i++){
            String name = br.readLine();
            nameList[i] = name;
            first.add(name.substring(0, 1));
        }
        
        for(String fname : first){
            int count = 0;
            
            for(String all : nameList){
                if(all.startsWith(fname)){
                    count++;
                }
            }
            
            if(count >= 5){
                sb.append(fname);
                allCount++;
            }
        }
        
        System.out.println(allCount > 0 ? sb : "PREDAJA");

    }
}