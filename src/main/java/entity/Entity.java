package entity;

import lombok.Data;
import utils.DateValidate;
import utils.NumberValidate;

/**
 * @ClassName: entity
 * @DESCRIPT: TODO
 * @AUTHOR: cuizhichao
 * @DATA: 2020/1/13 11:41 AM
 **/
@Data
public class Entity {

    @NumberValidate
    private String contractCode;

    private String supperName;

    private String counter;

    private String date;

    private String rentAdjust;

    private String propagandaFee;

    private String telFee;

    private String cleanFee;

    private String garbageFee;

    private String airFee;

    private String propertyFee;

    private String waterFee;

    private String electricFee;

    private String gasFee;

    private String calculateFee;

    private String valueCardFee;

    private String tranferFee;

    private String  adFee;

    private String otherFee;

    private String fixFee;

    private String promotionFee;

    private String manageFee;

    private String employeeFee;

    private String electricServiceFee;

    private String storageFee;

    @DateValidate(dateFormat = "YYYY-MM-dd")
    private String birthday;

}
