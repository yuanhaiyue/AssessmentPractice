package com.rj1902.demo.service;


import com.rj1902.demo.entity.Department;
import com.rj1902.demo.entity.Inquiry;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class DepartmentService {

    public String establish(Department department, HttpSession session){
        List<Department> list=(ArrayList<Department>)session.getAttribute("department");
        if (list==null) {
            list=new ArrayList<>();
            session.setAttribute("department",list);
        }
        department.isEmpty();
        department.setId(UUID.randomUUID().toString());
        department.establish();
        list.add(department);
        return "创建成功";
    }

    public List<Department> queryDepartment(HttpSession session){
        return (ArrayList<Department>)session.getAttribute("department");
    }

    public HashMap<String, Object> inquiryDepartment(Inquiry inquiry, HttpSession session){
        List<Department> list=(ArrayList<Department>)session.getAttribute("department");
        HashMap<String,Object> hashMap=new HashMap<>();
        int temp=0;
        if (inquiry.getDName()!=null){
            temp=1;
        }else if (inquiry.getPerson()!=null){
            temp=2;
        }
        if (temp==0) {
            hashMap.put("code", 500);
            hashMap.put("message", "查询失败检查输入是否正确");
            return hashMap;
        }
        for (Department d:list){
            if (temp==1){
                if (d.getDName().equals(inquiry.getDName())){
                    hashMap.put("code", 200);
                    hashMap.put("Department", d);
                    return hashMap;
                }
            }else {
                if (d.getPerson().equals(inquiry.getPerson())){
                    hashMap.put("code", 200);
                    hashMap.put("Department", d);
                    return hashMap;
                }
            }
        }
        hashMap.put("code", 500);
        hashMap.put("message", "未能找到指定部门");
        return hashMap;
    }
}
