Spring Framework
------------------------------------------------

    Objectives
        1. Spring Core and Depedency Injection
        2. Spring Data and Spring Data JPA
        3. Spring Boot
        4. Spring Web MVC

    Pre-Requisites
        1. Maven
        2. JDK 1.8 / Java 8
        3. JPA-Hibernate / any other ORM

    Lab Setup
        1. JDK 1.8
        2. STS (latest) IDE
        3. MySQL for RDBMS (optional) / H2DB

    Introduction

        Spring framework is a development platform nd a JavaEE framework that offers
        dependency injection as a core-feature.

        Dependency ?
            If that an artifact (say A) of an application is functionally
            dependent on another artifact (say B), then A is sadi to depend 
            on B or B is a dependency for A.

                interface EmpDao {
                    Employee add(Employee emp);
                }

                class EmpDaoImpl implements EmpDao {
                    //all code here...
                }

                interface EmpService{
                    Employee add(Employee emp);
                }

                class EmpServiceImpl implements EmpService {

                    private EmployeeDao dao;

                    public EmpSericeImpl(){
                        this.dao = new EmpDaoImpl();
                    }

                    public Employee add(Employee emp){
                        dao.add(emp);
                    }
                }

                //Service depends on DAO
                //DAO is the dependency
                //Service is the site

        Dependency Injection ?

            suppling dependencies into the site externally is 
            called dependency injection.
        
                interface EmpDao {
                    Employee add(Employee emp);
                }

                class EmpDaoJdbcImpl implements EmpDao {
                    //all code here...
                }

                class EmpDaoJpaImpl implements EmpDao {
                    //all code here...
                }                

                interface EmpService{
                    Employee add(Employee emp);
                }

                class EmpServiceImpl implements EmpService {

                    private EmpDao dao;

                    public EmpSericeImpl(EmpDao dao){
                        this.dao = dap;
                    }

                    public Employee add(Employee emp){
                        dao.add(emp);
                    }
                }

                //somewhere in main or so
                EmpService service = new EmplServiceImpl(new EmpDaoJdbcImpl());

                //or
                EmpService service = new EmplServiceImpl(new EmpDaoJpaImpl());

    Spring Modules

        Spring is highly modularized.

        Spring
                Core       base fundamental module needed for all other module to work, offers DI
                Context    offers ApplicationContext amd auto-wiring on top of DI
                SpEL       Spring Expression Language - offers injecting expressive part of beans
                AOP        Aspect Oriented Programming
                Web        Helps building MVC web apps and rest-apis 
                Data       Offers dynamically implemented Repositories/DAOs     
                Boot       Rapid Application Development through auto-config..; 

                Batch      Used to build batch processing applications 
                WebFlux    Used to buld asynchronous applications 
                Secure     Offers Authorization and Authentication 
                Test       Is a testing framework for all spring modules based applications 
                ....et.,

    Spring Core, Spring Context

        These module of spring framework offer Inversion Of Control (an implementation style of DI).

        Inversion of Control (IoC) is a principal of DI that says "DO NOT CALL; WE WILL CALL"

        The Life Cycle of the artifact Objects are managed automatically. Like object creation/
        injection or destruction is all automated.

        Terms To Remember

            Component           is a class whose objects are to be managed. (by Container)
            
            Bean                is an object of the Component OR is the object being managed by the Container.

            Container           is the class offered in psring framework that manages the life cycle of the bean.

                                Container creates, injects and destroys a Bean where the class of a Bean is called a
                                Component.

            Bean Configuaration     is to inform the container, list of Components or list of Beans  and their
                                    dependencies.

        Container

            Spring framework offers two interfaces as containers:

            BeanFactory                 from Spring Core Module     
            ApplicationContext          from Spring Context Module

            BeanFactory is less capable than ApplicationContext

        Bean Configuaration

            is to inform the Container - list of Components, list of Beans and dependency between them.

            Xml Based Configuaration
            Annotation Based Configuaration
            Java Baed Configuaration


            Annotation Based Configuaration

                @Configuaration
                @ComponentScan(basePackage)

                @Component("beanName")
                    ↑
                    |- @Service
                    |- @Controller
                    |- @Repository
                    |- @RestController
                    |- @Advise .......son.on;

                @Scope("singleton|prototype|request|session|global-session")

                @PropertySource("") //inform the name of the external properties source file.

                @Value("springExpression")  //inject primitive or strings values from external source into our component.
                
                    //Field Injection            
                    @Value("${app.name:UnNamed Application}")
                    private String appName;
                    
                    //Constructor Injection
                    @Value("${app.name:UnNamed Application}")
                    public ClassName(String appName){
                        this.appName = appName;
                    }
                    
                    //Setter Injection
                    @Value("${app.name:UnNamed Application}")
                    public void setAppName(String appName){
                        this.appName = appName;
                    }

                @Autowired

                    is used to inject a bean into another bean .

                    byType      a site is inject with a dependency as and when they are of the same type.
                                @Primary annotation can be used to pick a default matching bean in case
                                of having multiple matchings.

                    byName      injects a dependency whose name is mentioned using @Qualifier("beanName")

            Java Baed Configuaration

                create a bean perogramatically and register it with the Container.

                @Configuaration
                class MyConfig{

                    @Bean
                    public ClassName beanName(){
                        return new ClassName();
                    }
                }

    Spring Boot

        is a spring framework module that offers auto-configuaration resulting in
        Rapid Application Development.

        Configuarations as in

            Dependency Injection    Spring Context Module   ConfigurationClass, PropertySource ..et., has to be configed.
            WebApplication          Spring Web Module       DispatcherServlet, ViewResolvers, ..etc., has to be configed.
            Add Security            Spring Security Module  UserDeatilsService,AccessRules,AuthenticationType ..etc., has to be configed
            Add Data Impl           Spring Data JPA         ConnectionPools, Transaction Management ..etc., has to be configed

            and so on....

        Spring Auto-Configuaration is about providing default configs for any spring module, eleiminating
        the neccesscity of the repitative boiler-plate code and that makes the application
        ready-to-cook out of the box adding to the productivity.

        Spring Auto-configuaration is possible due to '-starter-' dependencies. Each spring module
        is defiend with a '-starter-' module that encapsulates the original dependency along
        with the default configs needed.

        Spring Boot also offers embeded servers. Servers like tomcat can be embeded intot he application 
        as a dependency making Spring Boot Applications stand-alone. This makes the spring boot application
        well suited for CONTAINERIZATION.

        @SpringBootApplication  =   @Configuration
                                    @AutoConfiguration
                                    @PropertySource                 //application.properties and/or application.yaml
                                    @ComponentScan                  //considers the package of the current class as basePackage

        SpringApplication.run(ConfigClass.class, commadnLineArgs)

            is the entire application box

            1. it creates a container (ApplicationContext)
            2. invoke all Spirng Runner Classes (if any)
            3. start the server (if any)
            4. waits until the server shuts down (if any)
            5. destroys the container
        
        A Spring Runner is any class that implements any of the below interfaces
            CommandLineRunner interface  offers public void run(String[] args)
            ApplicationRunner interface  offers public void run(Argument[] args)

        
    Assignment#1
            AddressBook

                We need a console based menu drive application to ADD/LIST/DELETE contacts
                where each contact has an id, fullName, dateOfBirth, mobileNumber,mailId as properties.

                class com.cts.adb.models.Contact
                
                interface com.cts.adb.service.ContactService
                    Contact add(Contact contact);
                    void deleteById(int contactId);
                    List<Contact> getAll();
                class com.cts.adb.service.ContactServiceImpl implements ContactService
                        is expected to a hypothetical list of contacts 

                class com.cts.adb.view.ContactsView

    Spring Data

        is a spring framework moduel that offers dynamic implementation to repositories.

    Spring Data JPA 

        is a sub-module of spring data that deals with repositories based on RDBMs.

        CrudRepository
            |
            |- JpaRepoisitory<E,pkType>

                E save(E);
                Optional<E> findById(pkType id);
                List<E> findAll():
                boolean existsById(pkType id);
                void deletebyId(pkType id);

            @Entity
            @Table(name="contacts")
            public class Contact {

                @Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                private Integer contactId;
                private String fullName;
                private String mobileNumber;
                private String meilId;
                private LocalDate dateOfBith;
            
                ///......
            }            

            public interface ContactRepo extends JpaRepository<Contact, Integer> {
                boolean existsByMailId(String mailId);
                boolean existsByMobileNumber(String mobileNumber);

                Optional<Contact> findByMailId(String mailId);
                Optional<Contact> findByMobileNumber(String mobileNumber);

                List<Contact> findAllByFullName(String fullName):

                @Query("SELECT c FROM Contact c WHERE c.dateOfBith BETWEEN :start AND :end")
                List<Contact> findAllBornBetween(LocalDate start,LocalDate end);
            }   

    Assignment#2
            HrApp

                We need a console based menu drive application to ADD/LIST/DELETE employees
                where each employee has an id, fullName, dateOfJoining, mailId, salary as properties.

                Use spring data jpa for persistence.
                Include the clause by functions for data retrival in the repos.

    Spring Web

        Dynamic Web Applications

            Are applictions that are capable of generating html content dynamically
            on the server and pas that content as a response to the client.

        Dynamic Web Application construction in JEE

            was using servlets and JSPs. 
            
            Servlets were used to recevie the http-request,
            parse the request and extract the data from the request and execute relevent
            operations and the final result of the operations were shared with JSP-pages.

            JSP-pages used to recevie the data (model) from Servlets and embed the
            data ina html-content and the final html-content rendered /generated
            is sent as a response.

        Model-View-Controller Archetecture

            Repositories <--entites--> Services <--model--> Controllers <--- Request------ Client
                                                            |                               ↑
                                                            | (model)                       |
                                                            |                               |
                                                            ↓                               |
                                                            Views   -----Response---------->|

            Controllers     wee servlets whsoe job is to parse the request and extract data from request
                            execute the relevent services and pass the result as model to the View

            Views           was JSP-Page / JFC / XHTML / ThymeLeaf ...etc.,
    

        Model-View-Controller FrontController Archetecture followed in Spring Web
        
            Repositories <--entites--> Services <--model--> Controllers <--model-- FrontController <--- Request------ Client
                                                                ↓                     ↑   |                               ↑
                                                                |----modelAndView-----|   | (model)                       |
                                                                                          |                               |
                                                                                          ↓                               |
                                                                                          Views   -----Response---------->|

            FrontController is provided by Spring Web. DispatcherServlet from Spring Web acts as FrontController.

                            This DispatcherServlet as a FrontController is resposnible to
                                1. Recevie all requests from Client
                                2. Extract any data or parameters from the request
                                3. Identify the respective action in a Controller for the incoming request
                                4. Invoke the identified action from the Controller and pass the extracted data ss model
                                5. Recevie the resultant model (if any) and ViewName from the action.
                                6. Share the resultant model with the view (that is identified by the viewName).

            Views           was JSP-Page / JFC / XHTML / ThymeLeaf ...etc.,

            Controllers     are any POJO class marked with @Controller annotation.

                            These Controller Classes are expected to have methods called actions.
                            These action methods must have relevent arguments to receive data (model) from FrontController.
                            These action methods must return a viewName as a String or viewName and model as an object of ModelAndView.

            How would a FrontController identify a relevent action from a Controller for an incoming Request?

                UrlHanlerMapping
                    |
                    |- BeanNameUrlHandlerMapping        (obslate)
                    |- SimpleUrlHandlerMapping

                SimpleUrlHandlerMapping

                        it expects each action to be marked with @RequestMapping(url,httpMethod).

                        Based on the url and method of the incoming request, the relelvent action is identified.

                        For Example, assuming the server is running on localhost:8080

                        @Controller
                        public class HomeController{
                            
                            @RequestMApping("/")                    /* http://localhost:8080 any method like GET or POST*/
                            public String indexAction(){
                                return "index";
                            }

                            @RequestMapping(value="/about",method=HttpMethod.GET) /* http://localhost:8080/about only for GET*/
                            public String aboutUsAction(){
                                return "aboutUs";
                            }
                        }

            How would a FrontController identify a VIEW for a given viewName?

                ViewResolver
                    |
                    |- BeanResourceViewResolver         (we have to give a .properties file mapping viewNAme=ViewPath)
                    |- XmlResourceViewResolver          (we have to give a .xml file mapping viewNAme=ViewPath)
                    |- InternalResourceViewResolver     (default for SpringBoot)

                InternalResourceViewResolver

                    ViewPath = prefix + viewName + suffix (where prefix and suffix are configurable properties of I-R-V-R)

                    assuming prefix is '/WEB-INF/pages' and suffix is '.jsp' 
                    for a given viewName 'index'
                    View is resolved as '/WEB-INF/pages/index.jsp'

