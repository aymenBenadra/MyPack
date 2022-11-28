package ma.youcode.mypack.daos.interfaces;

import ma.youcode.mypack.entities.TransactionEntity;

import java.util.List;

public interface ITransactionDAO extends IBaseDAO<TransactionEntity> {
    List<TransactionEntity> findByVille(String ville);
}
