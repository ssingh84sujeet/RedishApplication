package com.sujit.RedishApplication.Hash;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("Customer")
public class Customer implements Serializable {
    public static final long serialVersionUID=1L;

    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date dob;
    private String email;
    private String phone;


}
