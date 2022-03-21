package DAO;

import java.util.List;
import model.Administrateur;

public interface IadminDAO {
	 void saveAdministrateur(Administrateur Administrateur);

	 void updateAdministrateur(Administrateur Administrateur);

	 Administrateur getAdministrateurById(int id);

	 List<Administrateur> getAllAdministrateur();

	 void deleteAdministrateur(int id);

	

}
