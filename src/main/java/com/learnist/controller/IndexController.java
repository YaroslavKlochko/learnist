<<<<<<< HEAD
package com.english.learnist.controller;
=======
<<<<<<<< HEAD:src/main/java/com/english/learnist/controller/MainController.java

package com.english.learnist.controller;
========package com.learnist.controller;
>>>>>>>> lr-008_BE_create_entity_user:src/main/java/com/learnist/controller/IndexController.java
>>>>>>> lr-008_BE_create_entity_user

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
<<<<<<< HEAD
public class IndexController {

    @GetMapping
    public String getIndexPage() {
        return "index";
=======
<<<<<<<< HEAD:src/main/java/com/english/learnist/controller/MainController.java
public class MainController {
========
public class IndexController aqqqasq	dwqwdqw```>>>>>>>> lr-008_BE_create_entity_user:src/main/java/com/learnist/controller/IndexController.java

    @GetMapping(value = "/main")
    public String getMainPage() {
        return "main";
>>>>>>> lr-008_BE_create_entity_user
    
    }
}
