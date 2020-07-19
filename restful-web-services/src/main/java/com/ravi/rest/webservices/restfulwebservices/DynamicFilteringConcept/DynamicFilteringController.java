package com.ravi.rest.webservices.restfulwebservices.DynamicFilteringConcept;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DynamicFilteringController {

    @GetMapping("/dynamic-filter")
    public MappingJacksonValue getAnotherBean() {
        //I want to return field 1,2 and 3 of Another Bean when above url is called
        /*
            {
                "field1": "1",
                "field2": "2",
                "field3": "3"
            }
         */

        AnotherBean anotherBean = new AnotherBean("1", "2", "3", "4", "5");

        //"field1","field2","field3": Are variable inside Another Bean
        SimpleBeanPropertyFilter propertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2", "field3");

        FilterProvider filter = new SimpleFilterProvider().addFilter("someDynamicFilter", propertyFilter);

        MappingJacksonValue mapping = new MappingJacksonValue(anotherBean);
        mapping.setFilters(filter);

        return mapping;
    }

    @GetMapping("/dynamic-filter-anotherdemo")
    public MappingJacksonValue getAnotherBeanList() {
        //Now in this case, suppose I want to return field 4 and 5 of Another Bean when above url is called


        //Lets suppose we are returning list
        AnotherBean anotherBeanOne = new AnotherBean("1", "2", "3", "4", "5");
        AnotherBean anotherBeanTw0 = new AnotherBean("one", "two", "three", "four", "five");
        AnotherBean anotherBeanThree = new AnotherBean("I", "II", "III", "IV", "V");
        List<AnotherBean> beanList= new ArrayList();
        beanList.add(anotherBeanOne);
        beanList.add(anotherBeanTw0);
        beanList.add(anotherBeanThree);


        //"field1","field2","field3": Are variable inside Another Bean
        SimpleBeanPropertyFilter propertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field4", "field5");

        FilterProvider filter = new SimpleFilterProvider().addFilter("someDynamicFilter", propertyFilter);

        MappingJacksonValue mapping = new MappingJacksonValue(beanList);
        mapping.setFilters(filter);

        return mapping;
    }

}
