package DAO;

import java.util.List;

import model.Boisson;

public interface IboisDAO {
	 void saveBoisson(Boisson Boisson);

	 void updateBoisson(Boisson Boisson);

	 List<Boisson> getAllBoisson();

	 void deleteBoisson(int id);

	Boisson getBoissonById(int id);



	
}
