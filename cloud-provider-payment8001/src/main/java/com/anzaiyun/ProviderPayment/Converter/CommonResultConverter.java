package com.anzaiyun.ProviderPayment.Converter;

import com.anzaiyun.entity.CommonResult;
import org.springframework.core.convert.converter.Converter;

public class CommonResultConverter implements Converter<String, CommonResult> {
    @Override
    public CommonResult convert(String s) {
        CommonResult commonResult = new CommonResult();

        if (s != null){
            String[] items = s.split(":");
            commonResult.setCode(Integer.parseInt(items[0]));
            commonResult.setMessage(items[1]);
            commonResult.setData(items[2]);
        }

        return commonResult;
    }
}
