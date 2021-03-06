package com.edu.neu.studyapp.util;

import com.edu.neu.studyapp.entity.Choice;
import com.edu.neu.studyapp.mapper.ChoiceMapper;
import com.edu.neu.studyapp.service.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.util.StringUtils;

import java.util.*;

public class AnswerSheetUtil {
    public static Map<Integer,Integer> singleMap = new HashMap<>();
    public static Map<Integer, List<Integer>> multipleMap = new HashMap<>();
    public static void clear(){
        singleMap.clear();
        multipleMap.clear();
    }
    public static void initMap(String s){
        if(s != ""){
            String[] slist = s.split(";");
            System.out.println(slist.length);
            for(int i =0 ;i < slist.length; i++){
                if(slist[i].contains("-")){
                    String multiple_quest_id = StringUtils.substringBefore(slist[i],"-");
                    String multiple_choices = StringUtils.substringAfter(slist[i],"-");
                    String[] choices = multiple_choices.split(",");
                    List<Integer> choiceList = new ArrayList<>();
                    for(String string:choices){
                        choiceList.add(Integer.valueOf(string));

                    }
                    multipleMap.put(Integer.valueOf(multiple_quest_id),choiceList);
                }else {
                    String single_quest_id = StringUtils.substringBefore(slist[i],":");
                    String single_choice = StringUtils.substringAfter(slist[i],":");
                    singleMap.put(Integer.valueOf(single_quest_id),Integer.valueOf(single_choice));
                }
            }
        }

    }
    public static String sort(String result){
        String sortResult = "";
        String[] strings = result.split(";");
        quickSort(strings,0,strings.length-1);
        for(int i = 0; i < strings.length; i++){
            sortResult=sortResult+strings[i]+";";
        }
        return sortResult;
    }

    public static void quickSort(String[] arr,int low,int high){
        int i,j;
        String t,temp;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp???????????????
        temp = arr[low];

        while (i<j) {
            //?????????????????????????????????
            while (Integer.valueOf(StringUtils.substringBefore(temp,":"))<=Integer.valueOf(StringUtils.substringBefore(arr[j],":"))&&i<j) {
                j--;
            }
            //?????????????????????????????????
            while (Integer.valueOf(StringUtils.substringBefore(temp,":"))>=Integer.valueOf(StringUtils.substringBefore(arr[i],":"))&&i<j) {
                i++;
            }
            //???????????????????????????
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //?????????????????????i???j???????????????????????????
        arr[low] = arr[i];
        arr[i] = temp;
        //????????????????????????
        quickSort(arr, low, j-1);
        //????????????????????????
        quickSort(arr, j+1, high);
    }


}
