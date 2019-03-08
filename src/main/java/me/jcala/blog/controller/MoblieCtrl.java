package me.jcala.blog.controller;



import com.alibaba.fastjson.JSONObject;
import org.json.JSONArray;
//import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RestController
@RequestMapping(value = "/index")
public class MoblieCtrl {
    @RequestMapping(method=RequestMethod.POST)
    public Map splash(@RequestParam String splash){
        Map<String,String> mapping=new HashMap<String,String>();
        mapping.put("key",splash);
        return mapping;
    }
    //循环解析json需要知道是否json结尾为object
    @RequestMapping(value = "get",method=RequestMethod.POST)
    public@ResponseBody Map TabMain(@RequestBody String splash){
        Map<String,String> mapping=new HashMap<String,String>();
        mapping.put("key",splash.toString());
        try {
            JSONObject jsonObject =JSONObject.parseObject(splash);
            Iterator iterator = jsonObject.keySet().iterator();
            while (iterator.hasNext()) {
                String key = (String) iterator.next();
                String value = jsonObject.getString(key);
                mapping.put(key,value);
            }
        } catch (Throwable e) {
            e.printStackTrace();

        }
        return mapping;
    }
////    public static void analysisJson(Object objJson,Map<String, String> map) {
////        // 如果obj为json数组
////        if (objJson instanceof JSONArray) {
////            JSONArray objArray = (JSONArray) objJson;
////            for (int i = 0; i < objArray.length(); i++) {
////                analysisJson(objArray.get(i), map);
////            }
////        } else if (objJson instanceof JSONObject) {
////            JSONObject jsonObject = (JSONObject) objJson;
////            Iterator it = jsonObject.keys();
////            while (it.hasNext()) {
////                String key = it.next().toString();
////                Object object = jsonObject.get(key);++
////                        -
////                map.put(key,object);
////            }
////        }
////    }
//   public Map Str2Str(String keys,Object object){
//       Map mapping=new HashMap();
////       if(isObject(object)){
////           Str2Str(object);
////       }else{
////           Str2Map(object);
////       }
//       if (object instanceof JSONArray) {
//           JSONArray objArray = (JSONArray) object;
//           for (int i = 0; i < objArray.length(); i++) {
//               mapping.put(keys,Str2Str("",objArray.get(i)));
//           }
//       } else if (object instanceof JSONObject) {
//           JSONObject jsonObject = (JSONObject) object;
//           Iterator it = jsonObject.keys();
//           while (it.hasNext()) {
//               String key = (String) it.next();
//               if(isObject(jsonObject.getString(key))){
//                   mapping.put(jsonObject.getString(key),Str2Str("",jsonObject.getString(key)));
//               }else{
//                   mapping.put(jsonObject.getString(key),Str2Str("",jsonObject.getString(key)));
//               }
//               String value = jsonObject.getString(key);
//               mapping.put(key, value);
//
//
//           }
//       }
//       return mapping;
//   }
//   public Map Str2Map(Object object){
//       Map<String,String> mapping=new HashMap<String,String>();
//       return mapping;
//   }
//   public boolean isObject(Object object){
//       if (object instanceof JSONArray) {
//           return false;
//       }else if(object instanceof JSONObject){
//           return true;
//       }
//       return true;
//   }
}
