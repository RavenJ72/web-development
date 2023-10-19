package web.development.dto.input;

import web.development.dto.input.baseEntities.BaseEntityDto;

import java.time.LocalDateTime;

public class BrandDto extends BaseEntityDto {
    private String name;

    public BrandDto(Long id ,String name) {
        super(id);
        this.name = name;
    }

    public BrandDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
