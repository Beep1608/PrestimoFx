package org.example.loan_jewelry;

import org.example.buy_jewelry.dto.BuyJewelryIndex;
import org.example.loan_jewelry.index.LoanJewelryIndexDto;
import org.hibernate.Session;

import java.util.List;

public class LoanJewelryInteractor {

    private Session session;

    public LoanJewelryInteractor(Session session){
        this.session = session;
    }
    public List<LoanJewelryIndexDto> index(){
        String hql = "SELECT new org.example.loan_jewelry.index.LoanJewelryIndexDto(" +
                "b.id, b.final_loan, " +
                "CAST(j.weight AS string), j.caratage, j.description) " +
                "FROM LoanJewelryObject b JOIN b.jewelry j " +
                "ORDER BY b.id ASC";
        var lista =  session
                .createQuery(hql, LoanJewelryIndexDto.class)
                .getResultList();
        for (var item : lista){
            System.out.println("Item :"+ item.getWeight());
        }


        return  lista;
    }
}
