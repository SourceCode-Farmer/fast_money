package com.fastmoney.fast_money.backtask;

import java.util.List;

import com.fastmoney.fast_money.entity.CodeEntity;
import com.fastmoney.fast_money.entity.CompanyCodeEntity;
import com.fastmoney.fast_money.service.CodeService;
import com.fastmoney.fast_money.service.CompanyCodeServie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class UpdateCompanyCode{

    @Autowired
    CodeService codeService;

    @Autowired
    CompanyCodeServie companyCodeServie;

    @Scheduled(cron = "0/5 * * * * *")
    public void updateCode(){
        List<CodeEntity> codes = codeService.getAllCode();
        for(CodeEntity entity : codes){
            CompanyCodeEntity dat = new CompanyCodeEntity();
            dat.setName("");
            dat.setStatus(entity.getStatus());
            dat.setSymbol(entity.getSymbol());
            companyCodeServie.addCode(dat);
        }
    }

}