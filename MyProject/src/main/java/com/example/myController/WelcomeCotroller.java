package com.example.myController;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.myModel.Papagal;

@Controller
@RequestMapping(value = "/greeting")
public class WelcomeCotroller {

	// Model model = HashMap contains data to display into jsp
	@RequestMapping(value = "/hi",method=RequestMethod.GET)
	public String zdrastiBace(Model model/*, HttpServletRequest request*/) {
		
		// Load data from DAO
		// init connection to other services
		// do some other staff
		//prepare object to visualization
		
		model.addAttribute("greeting", "Ko staa? :)");
		return "hello";
	}
	
		// Model model = HashMap contains data to display into jsp
		@RequestMapping(value = "/bye",method=RequestMethod.GET)
		public String chaoBace(Model model) {
			
			// Load data from DAO
			// init connection to other services
			// do some other staff
			//prepare object to visualization
			
			model.addAttribute("greeting", "Ai chao :)");
			return "hello";
		}
		
		
		@RequestMapping(value = "/papagal/{papagalNomer}/room/{roomNumber}/etaj/{floorNumber}",method=RequestMethod.GET)
		public String etoTiPapagal(Model model,
									@PathVariable(value = "papagalNomer") Integer papagalNomer,
									@PathVariable(value="roomNumber") Integer roomNumber,
									@PathVariable(value="floorNumber") Integer floorNumber) {
			Papagal poli = new Papagal("Poli", 3);
			
			model.addAttribute(poli);
			model.addAttribute("papagalNomer",papagalNomer);
			model.addAttribute("roomNumber",roomNumber);
			model.addAttribute("floorNumber",floorNumber);
			
			return "papagal";
		}
	
	
	
}
