package com.demo.controllerlayer.service;

import com.demo.controllerlayer.model.TestDTO;
import org.springframework.stereotype.Service;

/**
 * @author cj
 * @created on 9/26/24
 */
@Service
public class TestService {
    public Double service(TestDTO testDTO) throws Exception {
        if (testDTO.getNum() <= 0) {
            throw new Exception("Number must be greater than 0");
        }
        if (testDTO.getType().equals("square")) {
            return Math.pow(testDTO.getNum(), 2);
        }
        if (testDTO.getType().equals("factorial")) {
            double result = 1;
            int num = testDTO.getNum();
            while (num > 1) {
                result *= num;
                num--;
            }
            return result;
        }
        throw new Exception("Invalid type");
    }
}
