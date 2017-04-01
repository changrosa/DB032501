package com.example.student.db032501;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by student on 2017/3/25.
 */

public class studentDAOMemoryImpl implements studentDAO {
    //ArrayList<student> data; //因為要保留資料，不要每次都一個，改為 static
    public static ArrayList<student> data = new ArrayList<>();

   /*因為要保留資料，不要每次都一個(物件)，改為 static 靜態

    原本的:
    public studentDAOMemoryImpl() {
        data = new ArrayList<>();
    }*/

    @Override
    public void clearAll() {
        data.clear();
    }
    @Override
    public void add(student s) {
        data.add(s);
    }

    @Override
    public void update(student s) {
        for (student d : data) {
            if (d.ID == s.ID) {
                d.Name = s.Name;
                d.Tel = s.Tel;
                d.Addr = s.Addr;
            }
        }
    }

    @Override
    public void remove(student s) {
        int i ;
        for (i=data.size()-1; i>=0 ; i--) { //倒著刪除，才不會刪除後 size 變小，造成多筆刪除時有錯
            if (data.get(i).ID == s.ID) {
                data.remove(i);
            }
        }

        /*此段是亂寫的
        int i = 0;
        for (student d : data) {
            if (d.ID == s.ID) {
              i++;
                System.out.println("===> " + i);
            }
        }
        data.remove(i);
        */
    }

    @Override
    public void remove(List<student> lst) { //多筆刪除
       int i;
        for (i=data.size()-1 ; i>=0 ; i--) {
            for (student s: lst) {
                if (data.get(i).ID == s.ID)
                    data.remove(i);
            }
        }
    }

    @Override
    public student getStudent(int ID) {
        return data.get(ID);
    }

    @Override
    public ArrayList<student> getAllStudents() {
        return data;
    }

}
