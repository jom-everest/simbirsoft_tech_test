/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simbirsoft.adapter;

import com.simbirsoft.data_loader.Map_SL;
import com.simbirsoft.entity.PersonInfo;
import java.util.List;
import com.simbirsoft.data_loader.DataLoaderInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** Класс создает персональные данные PersonInfo, извлекая их из обобщенного 
 загрузчика данных DataLoaderInterface
 *
 * @author slava
 */

@Component
public class PersonDataAdapter {
    private final DataLoaderInterface loader;
    
    @Autowired
    public PersonDataAdapter(DataLoaderInterface ld) {
        loader = ld;
    }
    
    // формирование данных PersonInfo
    public PersonInfo getData() throws DataLoaderInterface.DataLoaderException {
        // получение ассоциативного массива данных
        Map_SL map = loader.getData();
        PersonInfo pInfo = new PersonInfo();
        List<String> tmp;
        
        // извлечение необходимых данных из ассоциативного массива
        pInfo.fio = (tmp = map.safeGet(PersonInfo.FIO)).isEmpty() ? "" : tmp.get(0);
        pInfo.dob = (tmp = map.safeGet(PersonInfo.DOB)).isEmpty() ? "" : tmp.get(0);
        pInfo.email = (tmp = map.safeGet(PersonInfo.EMAIL)).isEmpty() ? "" : tmp.get(0);
        pInfo.skype = (tmp = map.safeGet(PersonInfo.SKYPE)).isEmpty() ? "" : tmp.get(0);
        pInfo.avatar = (tmp = map.safeGet(PersonInfo.AVATAR)).isEmpty() ? "" : tmp.get(0);
        pInfo.phone = (tmp = map.safeGet(PersonInfo.PHONE)).isEmpty() ? "" : tmp.get(0);
        
        pInfo.education = map.safeGet(PersonInfo.EDUCATION);
        pInfo.add_education = map.safeGet(PersonInfo.ADD_EDUCATION);
        pInfo.experience = map.safeGet(PersonInfo.EXPERIENCE);
        pInfo.hobbies = map.safeGet(PersonInfo.HOBBIES);
        pInfo.target = map.safeGet(PersonInfo.TARGET);
        pInfo.skills = map.safeGet(PersonInfo.SKILLS);
                
        return pInfo;
    }
}
