package ma.youcode.mypack.daos.interfaces;

import ma.youcode.mypack.entities.ChaufeurEntity;
import ma.youcode.mypack.entities.enums.VehiculeTypes;

public interface IChaufeurDAO {
    ChaufeurEntity findByVehiculeType(VehiculeTypes vehiculeType);
}
