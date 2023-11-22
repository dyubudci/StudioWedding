package com.example.studiowedding.network;

public class ManagerUrl {
    public static final String BASE_URL = "http://192.168.1.4:3000/api/";

    // Contract
    public  static  final String CONTRACTS="contracts";
    public  static  final String CONTRACTS_ID="contract/{idHopDong}";
    public  static  final String CONTRACTS_PAYMENT="contracts/payment";
    public  static  final String CONTRACTS_PROGESS="contracts/progess";
    public  static  final String CONTRACTS_INCURRENT="contracts/incurrent";
    public  static  final String ADD_CONTRACT="contract/add";
    public  static  final String CONTRACT_UPDATE="contract/update/{idHopDong}";
    public  static  final String CONTRACT_DELETE="contract/delete/{idHopDong}";
    public  static  final String INCURRENT="incurrent";
    public  static  final String INCURRENT_ADD="incurrent/add";
    public  static  final String INCURRENT_DELETE="incurrent/delete/{idPhatSinh}";
    public  static  final String CONTRACT_CLIENTS="contracts/clients";




    // Detail Contract
    public static final String CONTRACT_DETAILS_URL = "contract-details";
}
