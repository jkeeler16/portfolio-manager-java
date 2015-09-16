package com.es.manager.meter;

public class MeterTypeUnits {
	
	public static enum Unit {
		 CCF("ccf (hundred cubic feet)"),
		 CF("cf (cubic feet)"),
		 CGAL_UK("cGal (hundred gallons) (UK)"),
		 CGAL_US("cGal (hundred gallons) (US)"),
		 CM_PER_DAY("Cubic Meters per Day"),
		 CM("cm (Cubic meters)"),
		 CORD("Cords"),
		 GAL_UK("Gallons (UK)"),
		 GAL_US("Gallons (US)"),
		 GJ("GJ"),
		 KBTU("kBtu (thousand Btu)"),
		 KCF("kcf (thousand cubic feet)"),
		 KCM("Kcm (Thousand Cubic meters)"),
		 KGAL_UK("KGal (thousand gallons) (UK)"),
		 KGAL_US("KGal (thousand gallons) (US)"),
		 KG("Kilogram"),
		 KLBS("KLbs. (thousand pounds)"),
		 KWH("kWh (thousand Watt-hours)"),
		 L("Liters"),
		 MBTU("MBtu (million Btu)"),
		 MCF("MCF(million cubic feet)"),
		 MG_PER_L("mg/l (milligrams per liter)"),
		 MGAL_UK("MGal (million gallons) (UK)"),
		 MGAL_US("MGal (million gallons) (US)"),
		 MGAL_PER_DAY("Million Gallons per Day"),
		 MLBS("MLbs. (million pounds)"),
		 MWH("MWh (million Watt-hours)"),
		 LBS("pounds"),
		 LBS_PER_YEAR("Pounds per year"),
		 THERMS("therms"),
		 TONH("ton hours"),
		 TONNES("Tonnes (metric)"),
		 TONS("tons");
		
		private final String name;
		
		private Unit(String name){
			this.name = name;
		}
		
		@Override
		public String toString(){
			return name;
		}
	}
	
}
