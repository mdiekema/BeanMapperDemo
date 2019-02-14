# Bean Mapper Demo

This application is a simple comparison of various Java object mapping frameworks. The main classes are BeanMapperTest and CustomConverterTest, which tests out mapping properties using a standard and custom converter with different bean mapping frameworks. To try this out, simply import this as a Spring Boot application, run the tests, and make modifications as needed.

Based on the results of this demo, I assigned the following ratings to each bean mapper (1 being the lowest rating and 3 the best):

| | Dozer        | MapStruct      | ModelMapper  | Selma | BeanUtils|
| ------------- |:-------------:| :-----:| :----:| :---:| :----:| 
| Refactor Safe  | X | XXX | XXX | XXX | X|
| Ease of Use    | X | XX | XXX | XX | XX|
| Performance | X | XXX | XX | ? | ?|

I found ModelMapper the easiest to use, while offering relatively high performance and being easy to refactor. MapStruct typically required more configuration, but has the fastest performance of the ones looked at. Both would be good candidates for further research, as well as Selma, which looked very similar to MapStruct.
