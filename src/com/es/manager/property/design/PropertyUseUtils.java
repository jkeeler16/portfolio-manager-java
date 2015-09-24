package com.es.manager.property.design;

public class PropertyUseUtils {
	
	public static Class getClassForPropertyUseHint(String hint){
		switch (hint){
		case "K12 School":
			return K12SchoolType.class;
		case "Medical Office":
			return MedicalOfficeType.class;
		 		
		default:
			return null;
		}
	}
	
	public static Class getClassForBalancePropertyUseString(String use){
		switch (use) {
		case "Bank Branch":
			return BankBranchType.class;
		case "Barracks":
			return BarracksType.class;
		case "College/University":
			return CollegeUniversityType.class;
		case "Convenience Store w/ Gas Station":
			return ConvenienceStoreWithGasStationType.class;
		case "Convenience Stroe w/o Gas Station":
			return ConvenienceStoreWithoutGasStationType.class;
		case "Courthouse":
			return CourthouseType.class;
		case "Data Center":
			return DataCenterType.class;
		case "Drinking Water Treatment & Distribution":
			return DrinkingWaterTreatmentAndDistributionType.class;
		case "Financial Office":
			return FinancialOfficeType.class;
		case "Restaurant/Bar":
			return FoodSalesType.class;
		case "Other - Restaurant/Bar":
			return FoodSalesType.class;
		case "Hospital":
			return HospitalType.class;
		case "Hotel":
			return HotelType.class;
		case "K-12 School":
			return K12SchoolType.class;
		case "Medical Office":
			return MedicalOfficeType.class;
		case "Multifamily Housing":
			return MultifamilyHousingType.class;
		case "Warehouse/Distribution Center - NonRefrigerated":
			return NonRefrigeratedWarehouseType.class;
		case "Office":
			return OfficeType.class;
		case "Performing Arts":
			return OtherType.class;
		case "Mixed Use Property":
			return OtherType.class;
		case "Social/Meeting Hall":
			return OtherType.class;
		case "Pre-school/Daycare":
			return OtherType.class;
		case "Museum":
			return OtherType.class;
		case "Outpatient Rehabilitation/Physical Therapy":
			return OtherType.class;
		case "Other - Lodging/Residential":
			return OtherType.class;
		case "Movie Theater":
			return OtherType.class;
		case "Convention Center":
			return OtherType.class;
		case "Urgent Care/Clinic/Other":
			return OtherType.class;
		case "Vocational School":
			return OtherType.class;
		case "Ambulatory Surgical Center":
			return OtherType.class;
		case "Prison/Incarceration":
			return OtherType.class;
		case "Other - Eduction":
			return OtherType.class;
		case "Self-Storage Facility":
			return OtherType.class;
		case "Other - Utility":
			return OtherType.class;
		case "Energy/Power Station":
			return OtherType.class;
		case "Other - Technology/Science":
			return OtherType.class;
		case "Laboratory":
			return OtherType.class;
		case "Repair Services":
			return OtherType.class;
		case "Personal Services":
			return OtherType.class;
		case "Adult Education":
			return OtherType.class;
		case "Automobile Dealership":
			return OtherType.class;
		case "Veterinary Office":
			return OtherType.class;
		case "Mailing Center/Post Office":
			return OtherType.class;
		case "Recreation":
			return OtherType.class;
		case "Other":
			return OtherType.class;
		case "Manufacturing/Industrial Plant":
			return OtherType.class;
		case "Fire Station":
			return OtherType.class;
		case "Mall":
			return OtherType.class;
		case "Library":
			return OtherType.class;
		case "Transportation Terminal/Station":
			return OtherType.class;
		case "Other - Services":
			return OtherType.class;
		case "Police Station":
			return OtherType.class;
		case "Parking":
			return ParkingType.class;
		case "Warehouse/Distribution Center - Refrigerated":
			return RefrigeratedWarehouseType.class;
		case "Residence Hall/Dormitory":
			return ResidenceHallDormitoryType.class;
		case "Retail Store":
			return RetailType.class;
		case "Senior Care Community":
			return SeniorCareCommunityType.class;
		case "Single Family Home":
			return SingleFamilyHomeType.class;
		case "Stadium Closed":
			return StadiumClosedType.class;
		case "Stadium Open":
			return StadiumOpenType.class;
		case "Supermarket/Grocery Store":
			return SupermarketType.class;
		case "Swimming Pool":
			return SwimmingPoolType.class;
		case "Wastewater Treatment Plant":
			return WastewaterTreatmentPlantType.class;
		case "Wholesale Club/Supercenter":
			return WholesaleClubSupercenterType.class;
		case "Worship Facility":
			return WorshipFacilityType.class;
		default:
			return OtherType.class;
		
		}
	}
}
