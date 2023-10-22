package web.development.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import web.development.dto.input.*;
import web.development.models.enums.EngineType;
import web.development.models.enums.ModelCategory;
import web.development.models.enums.RoleType;
import web.development.models.enums.TransmissionType;
import web.development.services.interfaces.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleService roleService;

    private final UserService userService;

    private final BrandService brandService;

    private final ModelService modelService;
    private final OfferService offerService;

    @Autowired
    public DataInitializer(RoleService roleService, UserService userService, BrandService brandService, ModelService modelService, OfferService offerService) {
        this.roleService = roleService;
        this.userService = userService;
        this.brandService = brandService;
        this.modelService = modelService;
        this.offerService = offerService;
    }


    @Override
    public void run(String... args) throws Exception {
        seedData();
    }


    public void seedData() {


        UUID adminRoleId = roleService.save(new RoleDto(null, RoleType.ADMIN)).getId();

        UUID userRoleID = roleService.save(new RoleDto(null, RoleType.USER)).getId();

        UserDto adminUser = new UserDto(null, "Alex", "alex2023", "Alex", "Johnson", true, "alexj2023", roleService.findById(adminRoleId));
        UserDto userDto1 = new UserDto(null , "Вася", "111", "giga", "wqe", true, "123123", roleService.findById(userRoleID));
        UserDto userDto2 = new UserDto(null , "Антон", "111", "jopa", "sssss", true, "123123", roleService.findById(userRoleID));
        UserDto user1 = new UserDto(null, "Elena", "elena2023", "Elena", "Smith", true, "elenas123", roleService.findById(userRoleID));
        UserDto user2 = new UserDto(null, "Michael", "mike2023", "Michael", "Brown", true, "mikeb123", roleService.findById(userRoleID));
        UserDto user3 = new UserDto(null, "Sophia", "sophia2023", "Sophia", "Williams", true, "sophiaw123", roleService.findById(userRoleID));
        UserDto user4 = new UserDto(null, "Daniel", "danny2023", "Daniel", "Miller", true, "dannym123", roleService.findById(userRoleID));
        UserDto user5 = new UserDto(null, "Isabella", "izzy2023", "Isabella", "Davis", true, "izzyd123", roleService.findById(userRoleID));

        userService.save(userDto1);
        userService.save(userDto2);
        userService.save(adminUser);
        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
//
//
//        //можешь создать еще два бренда к моим
//        BrandDto brandDto = new BrandDto(null,"Tesla");
//        BrandDto brandDto2 = new BrandDto(null,"AUDI");
//        BrandDto brandDto3 = new BrandDto(null,"BMW");
//        BrandDto brandFord = new BrandDto(null, "Ford");
//
//
//        brandService.save(brandDto);
//        brandService.save(brandDto2);
//        brandService.save(brandDto3);
//        brandService.save(brandFord);
//
//        // Создаем модели для Tesla
//        ModelDto teslaModel1 = new ModelDto(null, "Model S", ModelCategory.CAR, "Электрический седан", 2012, 2023, brandService.findById(Long.parseLong("1")));
//        modelService.save(teslaModel1);
//
//        ModelDto teslaModel2 = new ModelDto(null, "Model 3", ModelCategory.CAR, "Электрический седан", 2017, 2023, brandService.findById(Long.parseLong("1")));
//        modelService.save(teslaModel2);
//
//        ModelDto teslaModel3 = new ModelDto(null, "Model X", ModelCategory.CAR, "Электрический кроссовер", 2015, 2023, brandService.findById(Long.parseLong("1")));
//        modelService.save(teslaModel3);
//
//        // Создаем модели для AUDI
//        ModelDto audiModel1 = new ModelDto(null, "A3", ModelCategory.CAR, "Компактный седан", 1996, 2023, brandService.findById(null));
//        modelService.save(audiModel1);
//
//        ModelDto audiModel2 = new ModelDto(null, "Q7", ModelCategory.CAR, "Полноразмерный кроссовер", 2005, 2023, brandService.findById(null));
//        modelService.save(audiModel2);
//
//        ModelDto audiModel3 = new ModelDto(null, "R8", ModelCategory.CAR, "Спорткар", 2006, 2023, brandService.findById(null));
//        modelService.save(audiModel3);
//
//        // Создаем модели для BMW
//        ModelDto bmwModel1 = new ModelDto(null, "3 Series", ModelCategory.CAR, "Седан среднего класса", 1975, 2023, brandService.findById(Long.parseLong("3")));
//        modelService.save(bmwModel1);
//
//        ModelDto bmwModel2 = new ModelDto(null, "X5", ModelCategory.CAR, "Кроссовер", 1999, 2023, brandService.findById(Long.parseLong("3")));
//        modelService.save(bmwModel2);
//
//        ModelDto bmwModel3 = new ModelDto(null, "i8", ModelCategory.CAR, "Гибридный спорткар", 2014, 2023, brandService.findById(Long.parseLong("3")));
//        modelService.save(bmwModel3);
//
//        // Создаем модели для Ford
//        ModelDto fordModel1 = new ModelDto(null, "Mustang", ModelCategory.CAR, "Спорткар", 1964, 2023, brandService.findById(Long.parseLong("4")));
//        modelService.save(fordModel1);
//
//        ModelDto fordModel2 = new ModelDto(null, "Explorer", ModelCategory.CAR, "Кроссовер", 1990, 2023, brandService.findById(Long.parseLong("4")));
//        modelService.save(fordModel2);
//
//        ModelDto fordModel3 = new ModelDto(null, "F-150", ModelCategory.CAR, "Пикап", 1975, 2023, brandService.findById(Long.parseLong("4")));
//        modelService.save(fordModel3);
//
//
//        OfferDto offerDto4 = new OfferDto(null,"very cool",EngineType.GASOLINE,"images/car/bigcar222.png",2200,new BigDecimal("50000.00"),TransmissionType.MANUAL,2000,modelService.findById(Long.parseLong("1")),userService.findById(Long.parseLong("4")));
//        OfferDto offerDto5 = new OfferDto(null,"Протеккает крыша",EngineType.GASOLINE,"images/supercar2.png",1223,new BigDecimal("5000000.00"),TransmissionType.MANUAL,2000,modelService.findById(null),userService.findById(Long.parseLong("5")));
//        OfferDto offerDto6 = new OfferDto(null,"Не работают тормаза, продаю со скидкой",EngineType.GASOLINE,"images/supercar22323.png",20120,new BigDecimal("12312310.00"),TransmissionType.MANUAL,2000,modelService.findById(Long.parseLong("3")),userService.findById(Long.parseLong("6")));
//        OfferDto offerDto7 = new OfferDto(null,"Новая, не бита, не крашена!",EngineType.GASOLINE,"images/supercar/secret/vehicle/momscar.png",20220,new BigDecimal("10000000.00"),TransmissionType.MANUAL,2000,modelService.findById(Long.parseLong("4")),userService.findById(Long.parseLong("7")));
//        offerService.save(offerDto4);
//        offerService.save(offerDto5);
//        offerService.save(offerDto6);
//        offerService.save(offerDto7);
//
//
//
//
//        modelService.findAll().forEach(System.out::println);
//        userService.findAll().forEach(System.out::println);
//        offerService.findAll().forEach(System.out::println);





























    }
}
