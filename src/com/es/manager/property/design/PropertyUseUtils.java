package com.es.manager.property.design;

import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.es.Client;
import com.es.manager.common.YesNo;
import com.es.manager.property.use.UseDecimalType;
import com.es.manager.property.use.UseIntegerType;
import com.es.manager.property.use.UseStringType;
import com.es.manager.property.use.UseYesNoType;

public class PropertyUseUtils {
	
	@SuppressWarnings("rawtypes")
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
	
	public static BasePropertyUseType getDefaultBasePropertyUseObject(String use, String name){
		switch (use) {
			case "Bank Branch":{
				BankBranchType useType = new BankBranchType();
				useType.setName(name);
				BankBranchType.UseDetails useDetails = new BankBranchType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setPercentOfficeCooled(getDefaultPercentOfficeCooledType());
				useDetails.setPercentOfficeHeated(getDefaultPercentOfficeHeatedType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Barracks":{
				BarracksType useType = new BarracksType();
				useType.setName(name);
				BarracksType.UseDetails useDetails = new BarracksType.UseDetails();
				useDetails.setHasComputerLab(getDefaultUseYesNoType());
				useDetails.setHasDiningHall(getDefaultUseYesNoType());
				useDetails.setNumberOfRooms(getDefaultUseDecimalType());
				useDetails.setPercentCooled(getDefaultPercentCooledType());
				useDetails.setPercentHeated(getDefaultPercentHeatedType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "College/University":{
				CollegeUniversityType useType = new CollegeUniversityType();
				useType.setName(name);
				CollegeUniversityType.UseDetails useDetails = new CollegeUniversityType.UseDetails();
				useDetails.setEnrollment(getDefaultUseDecimalType());
				useDetails.setGrantDollars(getDefaultUseDecimalType());
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfFTEWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Convenience Store with Gas Station":{
				ConvenienceStoreWithGasStationType useType = new ConvenienceStoreWithGasStationType();
				useType.setName(name);
				ConvenienceStoreWithGasStationType.UseDetails useDetails = new ConvenienceStoreWithGasStationType.UseDetails();
				useDetails.setAreaOfAllWalkInRefrigerationUnits(getDefaultOptionalFloorAreaType());
				useDetails.setCookingFacilities(getDefaultUseYesNoType());
				useDetails.setLengthOfAllOpenClosedRefrigerationUnits(getDefaultLengthType());
				useDetails.setNumberOfCashRegisters(getDefaultUseDecimalType());
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfOpenClosedRefrigerationUnits(getDefaultUseDecimalType());
				useDetails.setNumberOfWalkInRefrigerationUnits(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setPercentCooled(getDefaultPercentCooledType());
				useDetails.setPercentHeated(getDefaultPercentHeatedType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Convenience Store without Gas Station":{
				ConvenienceStoreWithoutGasStationType useType = new ConvenienceStoreWithoutGasStationType();
				useType.setName(name);
				ConvenienceStoreWithoutGasStationType.UseDetails useDetails = new ConvenienceStoreWithoutGasStationType.UseDetails();
				useDetails.setAreaOfAllWalkInRefrigerationUnits(getDefaultOptionalFloorAreaType());
				useDetails.setCookingFacilities(getDefaultUseYesNoType());
				useDetails.setLengthOfAllOpenClosedRefrigerationUnits(getDefaultLengthType());
				useDetails.setNumberOfCashRegisters(getDefaultUseDecimalType());
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfOpenClosedRefrigerationUnits(getDefaultUseDecimalType());
				useDetails.setNumberOfWalkInRefrigerationUnits(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setPercentCooled(getDefaultPercentCooledType());
				useDetails.setPercentHeated(getDefaultPercentHeatedType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Courthouse":{
				CourthouseType useType = new CourthouseType();
				useType.setName(name);
				CourthouseType.UseDetails useDetails = new CourthouseType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setPercentOfficeCooled(getDefaultPercentOfficeCooledType());
				useDetails.setPercentOfficeHeated(getDefaultPercentOfficeHeatedType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Data Center":{
				DataCenterType useType = new DataCenterType();
				useType.setName(name);
				DataCenterType.UseDetails useDetails = new DataCenterType.UseDetails();
				useDetails.setCoolingEquipmentRedundancy(getDefaultCoolingEquipmentRedundancyType());
				useDetails.setItEnergyMeterConfiguration(getDefaultItEnergyConfigurationType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setUpsSystemRedundancy(getDefaultUpsSystemRedundancyType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Drinking Water Treatment & Distribution":{
				DrinkingWaterTreatmentAndDistributionType useType = new DrinkingWaterTreatmentAndDistributionType();
				useType.setName(name);
				DrinkingWaterTreatmentAndDistributionType.UseDetails useDetails = new DrinkingWaterTreatmentAndDistributionType.UseDetails();
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Financial Office":{
				FinancialOfficeType useType = new FinancialOfficeType();
				useType.setName(name);
				FinancialOfficeType.UseDetails useDetails = new FinancialOfficeType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setPercentOfficeCooled(getDefaultPercentOfficeCooledType());
				useDetails.setPercentOfficeHeated(getDefaultPercentOfficeHeatedType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}	
			case "Restaurant/Bar":{
				FoodSalesType useType = new FoodSalesType();
				useType.setName(name);
				FoodSalesType.UseDetails useDetails = new FoodSalesType.UseDetails();
				useDetails.setAreaOfAllWalkInRefrigerationUnits(getDefaultOptionalFloorAreaType());
				useDetails.setCookingFacilities(getDefaultUseYesNoType());
				useDetails.setLengthOfAllOpenClosedRefrigerationUnits(getDefaultLengthType());
				useDetails.setNumberOfCashRegisters(getDefaultUseDecimalType());
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfOpenClosedRefrigerationUnits(getDefaultUseDecimalType());
				useDetails.setNumberOfWalkInRefrigerationUnits(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setPercentCooled(getDefaultPercentCooledType());
				useDetails.setPercentHeated(getDefaultPercentHeatedType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Other - Restaurant/Bar":{
				FoodSalesType useType = new FoodSalesType();
				useType.setName(name);
				FoodSalesType.UseDetails useDetails = new FoodSalesType.UseDetails();
				useDetails.setAreaOfAllWalkInRefrigerationUnits(getDefaultOptionalFloorAreaType());
				useDetails.setCookingFacilities(getDefaultUseYesNoType());
				useDetails.setLengthOfAllOpenClosedRefrigerationUnits(getDefaultLengthType());
				useDetails.setNumberOfCashRegisters(getDefaultUseDecimalType());
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfOpenClosedRefrigerationUnits(getDefaultUseDecimalType());
				useDetails.setNumberOfWalkInRefrigerationUnits(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setPercentCooled(getDefaultPercentCooledType());
				useDetails.setPercentHeated(getDefaultPercentHeatedType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Hospital":{
				HospitalType useType = new HospitalType();
				useType.setName(name);
				HospitalType.UseDetails useDetails = new HospitalType.UseDetails();
				useDetails.setHasLaboratory(getDefaultUseYesNoType());
				useDetails.setIsTertiaryCare(getDefaultUseYesNoType());
				useDetails.setLicensedBedCapacity(getDefaultUseDecimalType());
				useDetails.setMaximumNumberOfFloors(getDefaultUseIntegerType());
				useDetails.setNumberOfFTEWorkers(getDefaultUseDecimalType());
				useDetails.setNumberOfMriMachines(getDefaultUseDecimalType());
				useDetails.setNumberOfStaffedBeds(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setOnSiteLaundryFacility(getDefaultUseYesNoType());
				useDetails.setOwnedBy(getDefaultOwnedByType());
				useDetails.setPercentCooled(getDefaultPercentCooledType());
				useDetails.setPercentHeated(getDefaultPercentHeatedType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Hotel":{
				HotelType useType = new HotelType();
				useType.setName(name);
				HotelType.UseDetails useDetails = new HotelType.UseDetails();
				useDetails.setAmountOfLaundryProcessedAnnually(getDefaultAmountOfLaundryProcessedAnnuallyType());
				useDetails.setCookingFacilities(getDefaultUseYesNoType());
				useDetails.setFullServiceSpaFloorArea(getDefaultOptionalFloorAreaType());
				useDetails.setGymCenterFloorArea(getDefaultOptionalFloorAreaType());
				useDetails.setHoursPerDayGuestsOnsite(getDefaultHoursPerDayGuestsOnsiteType());
				useDetails.setLaundryFacility(getDefaultOnsiteLaundryType());
				useDetails.setNumberOfCommercialRefrigerationUnits(getDefaultUseDecimalType());
				useDetails.setNumberOfGuestMealsServedPerYear(getDefaultUseIntegerType());
				useDetails.setNumberOfHotelRooms(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setPercentCooled(getDefaultPercentCooledType());
				useDetails.setPercentHeated(getDefaultPercentHeatedType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "K-12 School":{
				K12SchoolType useType = new K12SchoolType();
				useType.setName(name);
				K12SchoolType.UseDetails useDetails = new K12SchoolType.UseDetails();
				useDetails.setCookingFacilities(getDefaultUseYesNoType());
				useDetails.setGymnasiumFloorArea(getDefaultOptionalFloorAreaType());
				useDetails.setIsHighSchool(getDefaultUseYesNoType());
				useDetails.setMonthsInUse(getDefaultMonthsInUseType());
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWalkInRefrigerationUnits(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setOpenOnWeekends(getDefaultUseYesNoType());
				useDetails.setPercentCooled(getDefaultPercentCooledType());
				useDetails.setPercentHeated(getDefaultPercentHeatedType());
				useDetails.setSchoolDistrict(getDefaultUseStringType());
				useDetails.setStudentSeatingCapacity(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Medical Office":{
				MedicalOfficeType useType = new MedicalOfficeType();
				useType.setName(name);
				MedicalOfficeType.UseDetails useDetails = new MedicalOfficeType.UseDetails();
				useDetails.setNumberOfMriMachines(getDefaultUseDecimalType());
				useDetails.setNumberOfSurgicalOperatingBeds(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setPercentCooled(getDefaultPercentCooledType());
				useDetails.setPercentHeated(getDefaultPercentHeatedType());
				useDetails.setSurgeryCenterFloorArea(getDefaultOptionalFloorAreaType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Multifamily Housing":{
				MultifamilyHousingType useType = new MultifamilyHousingType();
				useType.setName(name);
				MultifamilyHousingType.UseDetails useDetails = new MultifamilyHousingType.UseDetails();
				useDetails.setGovernmentSubsidizedHousing(getDefaultUseYesNoType());
				useDetails.setNumberOfBedrooms(getDefaultUseDecimalType());
				useDetails.setNumberOfLaundryHookupsInAllUnits(getDefaultUseIntegerType());
				useDetails.setNumberOfLaundryHookupsInCommonArea(getDefaultUseIntegerType());
				useDetails.setNumberOfResidentialLivingUnits(getDefaultUseDecimalType());
				useDetails.setNumberOfResidentialLivingUnitsHighRiseSetting(getDefaultUseDecimalType());
				useDetails.setNumberOfResidentialLivingUnitsLowRiseSetting(getDefaultUseDecimalType());
				useDetails.setNumberOfResidentialLivingUnitsMidRiseSetting(getDefaultUseDecimalType());
				useDetails.setPercentCooled(getDefaultPercentCooledType());
				useDetails.setPercentHeated(getDefaultPercentHeatedType());
				useDetails.setResidentPopulation(getDefaultResidentPopulationType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Non-Refrigerated Warehouse":{
				NonRefrigeratedWarehouseType useType = new NonRefrigeratedWarehouseType();
				useType.setName(name);
				NonRefrigeratedWarehouseType.UseDetails useDetails = new NonRefrigeratedWarehouseType.UseDetails();
				useDetails.setNumberOfWalkInRefrigerationUnits(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setPercentCooled(getDefaultPercentCooledType());
				useDetails.setPercentHeated(getDefaultPercentHeatedType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Office":{
				OfficeType useType = new OfficeType();
				useType.setName(name);
				OfficeType.UseDetails useDetails = new OfficeType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setPercentOfficeCooled(getDefaultPercentOfficeCooledType());
				useDetails.setPercentOfficeHeated(getDefaultPercentOfficeHeatedType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Performing Arts":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Mixed Use Property":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Social/Meeting Hall":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Pre-school/Daycare":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Museum":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Outpatient Rehabilitation/Physical Therapy":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Other - Lodging/Residential":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Movie Theater":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Convention Center":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Urgent Care/Clinic/Other":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Vocational School":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Ambulatory Surgical Center":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Prison/Incarceration":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Other - Eduction":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Self-Storage Facility":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Other - Utility":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Energy/Power Station":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Other - Technology/Science":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Laboratory":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Repair Services":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Personal Services (Health/Beauty, Dry Cleaning, etc)":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Adult Education":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Automobile Dealership":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Veterinary Office":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Mailing Center/Post Office":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Recreation":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Other":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Manufacturing/Industrial Plant":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Fire Station":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Mall":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Library":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Transportation Terminal/Station":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Other - Services":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Police Station":{
				OtherType useType = new OtherType();
				useType.setName(name);
				OtherType.UseDetails useDetails = new OtherType.UseDetails();
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Parking":{
				ParkingType useType = new ParkingType();
				useType.setName(name);
				ParkingType.UseDetails useDetails = new ParkingType.UseDetails();
				useDetails.setCompletelyEnclosedFootage(getDefaultGrossFloorAreaType());
				useDetails.setOpenFootage(getDefaultGrossFloorAreaType());
				useDetails.setPartiallyEnclosedFootage(getDefaultGrossFloorAreaType());
				useDetails.setSupplementalHeating(getDefaultUseYesNoType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Refrigerated Warehouse":{
				RefrigeratedWarehouseType useType = new RefrigeratedWarehouseType();
				useType.setName(name);
				RefrigeratedWarehouseType.UseDetails useDetails = new RefrigeratedWarehouseType.UseDetails();
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Residence Hall/Dormitory":{
				ResidenceHallDormitoryType useType = new ResidenceHallDormitoryType();
				useType.setName(name);
				ResidenceHallDormitoryType.UseDetails useDetails = new ResidenceHallDormitoryType.UseDetails();
				useDetails.setHasComputerLab(getDefaultUseYesNoType());
				useDetails.setHasDiningHall(getDefaultUseYesNoType());
				useDetails.setNumberOfRooms(getDefaultUseDecimalType());
				useDetails.setPercentCooled(getDefaultPercentCooledType());
				useDetails.setPercentHeated(getDefaultPercentHeatedType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Retail Store":{
				RetailType useType = new RetailType();
				useType.setName(name);
				RetailType.UseDetails useDetails = new RetailType.UseDetails();
				useDetails.setAreaOfAllWalkInRefrigerationUnits(getDefaultOptionalFloorAreaType());
				useDetails.setCookingFacilities(getDefaultUseYesNoType());
				useDetails.setExteriorEntranceToThePublic(getDefaultUseYesNoType());
				useDetails.setLengthOfAllOpenClosedRefrigerationUnits(getDefaultLengthType());
				useDetails.setNumberOfCashRegisters(getDefaultUseDecimalType());
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfOpenClosedRefrigerationUnits(getDefaultUseDecimalType());
				useDetails.setNumberOfWalkInRefrigerationUnits(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setPercentCooled(getDefaultPercentCooledType());
				useDetails.setPercentHeated(getDefaultPercentHeatedType());
				useDetails.setSingleStore(getDefaultUseYesNoType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Senior Care Community":{
				SeniorCareCommunityType useType = new SeniorCareCommunityType();
				useType.setName(name);
				SeniorCareCommunityType.UseDetails useDetails = new SeniorCareCommunityType.UseDetails();
				useDetails.setAverageNumberOfResidents(getDefaultUseDecimalType());
				useDetails.setLicensedBedCapacity(getDefaultUseDecimalType());
				useDetails.setMaximumResidentCapacity(getDefaultUseDecimalType());
				useDetails.setNumberOfCommercialRefrigerationUnits(getDefaultUseDecimalType());
				useDetails.setNumberOfCommercialWashingMachines(getDefaultUseDecimalType());
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfResidentialLiftSystems(getDefaultUseDecimalType());
				useDetails.setNumberOfResidentialLivingUnits(getDefaultUseDecimalType());
				useDetails.setNumberOfResidentialWashingMachines(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setPercentCooled(getDefaultPercentCooledType());
				useDetails.setPercentHeated(getDefaultPercentHeatedType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Single Family Home":{
				SingleFamilyHomeType useType = new SingleFamilyHomeType();
				useType.setName(name);
				SingleFamilyHomeType.UseDetails useDetails = new SingleFamilyHomeType.UseDetails();
				useDetails.setNumberOfBedrooms(getDefaultUseDecimalType());
				useDetails.setNumberOfPeople(getDefaultUseIntegerType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Stadium Closed":{
				StadiumClosedType useType = new StadiumClosedType();
				useType.setName(name);
				StadiumClosedType.UseDetails useDetails = new StadiumClosedType.UseDetails();
				useDetails.setEnclosedFloorArea(getDefaultOptionalFloorAreaType());
				useDetails.setIceEvents(getDefaultUseYesNoType());
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfConcertShowEventsPerYear(getDefaultUseIntegerType());
				useDetails.setNumberOfSpecialOtherEventsPerYear(getDefaultUseIntegerType());
				useDetails.setNumberOfSportingEventsPerYear(getDefaultUseIntegerType());
				useDetails.setNumberOfWalkInRefrigerationUnits(getDefaultUseDecimalType());
				useDetails.setPercentCooled(getDefaultPercentCooledType());
				useDetails.setPercentHeated(getDefaultPercentHeatedType());
				useDetails.setSizeOfElectronicScoreBoards(getDefaultOptionalFloorAreaType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Stadium Open":{
				StadiumOpenType useType = new StadiumOpenType();
				useType.setName(name);
				StadiumOpenType.UseDetails useDetails = new StadiumOpenType.UseDetails();
				useDetails.setEnclosedFloorArea(getDefaultOptionalFloorAreaType());
				useDetails.setIceEvents(getDefaultUseYesNoType());
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfConcertShowEventsPerYear(getDefaultUseIntegerType());
				useDetails.setNumberOfSpecialOtherEventsPerYear(getDefaultUseIntegerType());
				useDetails.setNumberOfSportingEventsPerYear(getDefaultUseIntegerType());
				useDetails.setNumberOfWalkInRefrigerationUnits(getDefaultUseDecimalType());
				useDetails.setPercentCooled(getDefaultPercentCooledType());
				useDetails.setPercentHeated(getDefaultPercentHeatedType());
				useDetails.setSizeOfElectronicScoreBoards(getDefaultOptionalFloorAreaType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Supermarket/Grocery Store":{
				SupermarketType useType = new SupermarketType();
				useType.setName(name);
				SupermarketType.UseDetails useDetails = new SupermarketType.UseDetails();
				useDetails.setAreaOfAllWalkInRefrigerationUnits(getDefaultOptionalFloorAreaType());
				useDetails.setCookingFacilities(getDefaultUseYesNoType());
				useDetails.setLengthOfAllOpenClosedRefrigerationUnits(getDefaultLengthType());
				useDetails.setNumberOfCashRegisters(getDefaultUseDecimalType());
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfOpenClosedRefrigerationUnits(getDefaultUseDecimalType());
				useDetails.setNumberOfWalkInRefrigerationUnits(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setPercentCooled(getDefaultPercentCooledType());
				useDetails.setPercentHeated(getDefaultPercentHeatedType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Swimming Pool":{
				SwimmingPoolType useType = new SwimmingPoolType();
				useType.setName(name);
				SwimmingPoolType.UseDetails useDetails = new SwimmingPoolType.UseDetails();
				useDetails.setMonthsInUse(getDefaultMonthsInUseType());
				useDetails.setPoolLocation(getDefaultPoolType());
				useDetails.setPoolSize(getDefaultPoolSizeType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Wastewater Treatment Plant":{
				WastewaterTreatmentPlantType useType = new WastewaterTreatmentPlantType();
				useType.setName(name);
				WastewaterTreatmentPlantType.UseDetails useDetails = new WastewaterTreatmentPlantType.UseDetails();
				useDetails.setAverageEffluentBiologicalOxygenDemand(getDefaultUseDecimalType());
				useDetails.setAverageInfluentBiologicalOxygenDemand(getDefaultUseDecimalType());
				useDetails.setFixedFilmTrickleFiltrationProcess(getDefaultUseYesNoType());
				useDetails.setNutrientRemoval(getDefaultUseYesNoType());
				useDetails.setPlantDesignFlowRate(getDefaultPlantDesignFlowRateType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Wholesale Club/Supercenter":{
				WholesaleClubSupercenterType useType = new WholesaleClubSupercenterType();
				useType.setName(name);
				WholesaleClubSupercenterType.UseDetails useDetails = new WholesaleClubSupercenterType.UseDetails();
				useDetails.setAreaOfAllWalkInRefrigerationUnits(getDefaultOptionalFloorAreaType());
				useDetails.setCookingFacilities(getDefaultUseYesNoType());
				useDetails.setExteriorEntranceToThePublic(getDefaultUseYesNoType());
				useDetails.setLengthOfAllOpenClosedRefrigerationUnits(getDefaultLengthType());
				useDetails.setNumberOfCashRegisters(getDefaultUseDecimalType());
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfOpenClosedRefrigerationUnits(getDefaultUseDecimalType());
				useDetails.setNumberOfWalkInRefrigerationUnits(getDefaultUseDecimalType());
				useDetails.setNumberOfWorkers(getDefaultUseDecimalType());
				useDetails.setPercentCooled(getDefaultPercentCooledType());
				useDetails.setPercentHeated(getDefaultPercentHeatedType());
				useDetails.setSingleStore(getDefaultUseYesNoType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			case "Worship Facility":{
				WorshipFacilityType useType = new WorshipFacilityType();
				useType.setName(name);
				WorshipFacilityType.UseDetails useDetails = new WorshipFacilityType.UseDetails();
				useDetails.setCookingFacilities(getDefaultUseYesNoType());
				useDetails.setNumberOfCommercialRefrigerationUnits(getDefaultUseDecimalType());
				useDetails.setNumberOfComputers(getDefaultUseDecimalType());
				useDetails.setNumberOfWeekdaysOpen(getDefaultNumberOfWeekdaysType());
				useDetails.setSeatingCapacity(getDefaultUseDecimalType());
				useDetails.setTotalGrossFloorArea(getDefaultGrossFloorAreaType());
				useDetails.setWeeklyOperatingHours(getDefaultUseDecimalType());
				useType.setUseDetails(useDetails);
				return useType;
			}
			default:{
				throw new IllegalArgumentException("No default properties defined for type: " + use);
			}
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	public static BasePropertyUseType getPropertyUseForPropertyId(Client client, Long propertyUseId, String use){
		switch (use) {
		case "Bank Branch":
			return client.getPropertyUse(propertyUseId, BankBranchType.class);
		case "Barracks":
			return client.getPropertyUse(propertyUseId, BarracksType.class);
		case "College/University":
			return client.getPropertyUse(propertyUseId, CollegeUniversityType.class);
		case "Convenience Store with Gas Station":
			return client.getPropertyUse(propertyUseId, ConvenienceStoreWithGasStationType.class);
		case "Convenience Store without Gas Station":
			return client.getPropertyUse(propertyUseId, ConvenienceStoreWithoutGasStationType.class);
		case "Courthouse":
			return client.getPropertyUse(propertyUseId, CourthouseType.class);
		case "Data Center":
			return client.getPropertyUse(propertyUseId, DataCenterType.class);
		case "Drinking Water Treatment & Distribution":
			return client.getPropertyUse(propertyUseId, DrinkingWaterTreatmentAndDistributionType.class);
		case "Financial Office":
			return client.getPropertyUse(propertyUseId, FinancialOfficeType.class);
		case "Restaurant/Bar":
			return client.getPropertyUse(propertyUseId, FoodSalesType.class);
		case "Other - Restaurant/Bar":
			return client.getPropertyUse(propertyUseId, FoodSalesType.class);
		case "Hospital":
			return client.getPropertyUse(propertyUseId, HospitalType.class);
		case "Hotel":
			return client.getPropertyUse(propertyUseId, HotelType.class);
		case "K-12 School":
			return client.getPropertyUse(propertyUseId, K12SchoolType.class);
		case "Medical Office":
			return client.getPropertyUse(propertyUseId, MedicalOfficeType.class);
		case "Multifamily Housing":
			return client.getPropertyUse(propertyUseId, MultifamilyHousingType.class);
		case "Non-Refrigerated Warehouse":
			return client.getPropertyUse(propertyUseId, NonRefrigeratedWarehouseType.class);
		case "Office":
			return client.getPropertyUse(propertyUseId, OfficeType.class);
		case "Performing Arts":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Mixed Use Property":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Social/Meeting Hall":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Pre-school/Daycare":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Museum":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Outpatient Rehabilitation/Physical Therapy":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Other - Lodging/Residential":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Movie Theater":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Convention Center":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Urgent Care/Clinic/Other":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Vocational School":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Ambulatory Surgical Center":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Prison/Incarceration":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Other - Eduction":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Self-Storage Facility":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Other - Utility":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Energy/Power Station":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Other - Technology/Science":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Laboratory":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Repair Services":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Personal Services (Health/Beauty, Dry Cleaning, etc)":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Adult Education":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Automobile Dealership":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Veterinary Office":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Mailing Center/Post Office":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Recreation":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Other":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Manufacturing/Industrial Plant":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Fire Station":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Mall":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Library":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Transportation Terminal/Station":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Other - Services":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Police Station":
			return client.getPropertyUse(propertyUseId, OtherType.class);
		case "Parking":
			return client.getPropertyUse(propertyUseId, ParkingType.class);
		case "Refrigerated Warehouse":
			return client.getPropertyUse(propertyUseId, RefrigeratedWarehouseType.class);
		case "Residence Hall/Dormitory":
			return client.getPropertyUse(propertyUseId, ResidenceHallDormitoryType.class);
		case "Retail Store":
			return client.getPropertyUse(propertyUseId, RetailType.class);
		case "Senior Care Community":
			return client.getPropertyUse(propertyUseId, SeniorCareCommunityType.class);
		case "Single Family Home":
			return client.getPropertyUse(propertyUseId, SingleFamilyHomeType.class);
		case "Stadium Closed":
			return client.getPropertyUse(propertyUseId, StadiumClosedType.class);
		case "Stadium Open":
			return client.getPropertyUse(propertyUseId, StadiumOpenType.class);
		case "Supermarket/Grocery Store":
			return client.getPropertyUse(propertyUseId, SupermarketType.class);
		case "Swimming Pool":
			return client.getPropertyUse(propertyUseId, SwimmingPoolType.class);
		case "Wastewater Treatment Plant":
			return client.getPropertyUse(propertyUseId, WastewaterTreatmentPlantType.class);
		case "Wholesale Club/Supercenter":
			return client.getPropertyUse(propertyUseId, WholesaleClubSupercenterType.class);
		case "Worship Facility":
			return client.getPropertyUse(propertyUseId, WorshipFacilityType.class);
		default:
			return client.getPropertyUse(propertyUseId, OtherType.class);
		
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static Class getClassForBalancePropertyUseString(String use){
		switch (use) {
		case "Bank Branch":
			return BankBranchType.class;
		case "Barracks":
			return BarracksType.class;
		case "College/University":
			return CollegeUniversityType.class;
		case "Convenience Store with Gas Station":
			return ConvenienceStoreWithGasStationType.class;
		case "Convenience Store without Gas Station":
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
		case "Non-Refrigerated Warehouse":
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
		case "Personal Services (Health/Beauty, Dry Cleaning, etc)":
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
		case "Refrigerated Warehouse":
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
	
	private static XMLGregorianCalendar getDefaultDate(){
		XMLGregorianCalendar value;
		try {
			GregorianCalendar c = new GregorianCalendar();

			c.set(1970, 0, 1,
					0, 0, 0);
			c.setTimeZone(TimeZone.getTimeZone("GMT"));
			value = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			return value;
		}
		catch (Exception e){
			//throw new Exception("Unable to create default XMLGregorianCalendar object.", e);
			return null;
		}
	}
	
	private static UseDecimalType getDefaultUseDecimalType(){
		UseDecimalType useType = new UseDecimalType();
		useType.setTemporary(true);
		useType.setValue(BigDecimal.valueOf(0));
		useType.setCurrentAsOf(getDefaultDate());
		return useType;
	}
	
	private static UseIntegerType getDefaultUseIntegerType(){
		UseIntegerType useType = new UseIntegerType();
		useType.setTemporary(true);
		useType.setValue(0);
		useType.setCurrentAsOf(getDefaultDate());
		return useType;
	}
	
	private static UseStringType getDefaultUseStringType(){
		UseStringType useType = new UseStringType();
		useType.setTemporary(true);
		useType.setValue("");
		useType.setCurrentAsOf(getDefaultDate());
		return useType;
	}
		
	private static UseYesNoType getDefaultUseYesNoType(){
		UseYesNoType useType = new UseYesNoType();
		useType.setTemporary(true);
		useType.setValue(YesNo.NO);
		useType.setCurrentAsOf(getDefaultDate());
		return useType;
	}
	
	private static PercentOfficeCooledType getDefaultPercentOfficeCooledType(){
		PercentOfficeCooledType useType = new PercentOfficeCooledType();
		useType.setTemporary(true);
		useType.setValue("50% or more");
		useType.setCurrentAsOf(getDefaultDate());
		return useType;
	}
	
	private static PercentOfficeHeatedType getDefaultPercentOfficeHeatedType(){
		PercentOfficeHeatedType useType = new PercentOfficeHeatedType();
		useType.setTemporary(true);
		useType.setValue("50% or more");
		useType.setCurrentAsOf(getDefaultDate());
		return useType;
	}
	
	private static PercentCooledType getDefaultPercentCooledType(){
		PercentCooledType useType = new PercentCooledType();
		useType.setTemporary(true);
		useType.setValue("0");
		useType.setCurrentAsOf(getDefaultDate());
		return useType;
	}
	
	private static PercentHeatedType getDefaultPercentHeatedType(){
		PercentHeatedType useType = new PercentHeatedType();
		useType.setTemporary(true);
		useType.setValue("0");
		useType.setCurrentAsOf(getDefaultDate());
		return useType;
	}
	
	private static GrossFloorAreaType getDefaultGrossFloorAreaType(){
		GrossFloorAreaType useType = new GrossFloorAreaType();
		useType.setTemporary(true);
		useType.setValue(0);
		useType.setCurrentAsOf(getDefaultDate());
		useType.setUnits(GrossFloorAreaUnitsType.SQUARE_FEET);
		return useType;
	}
	
	private static OptionalFloorAreaType getDefaultOptionalFloorAreaType(){
		OptionalFloorAreaType useType = new OptionalFloorAreaType();
		useType.setTemporary(true);
		useType.setValue(0);
		useType.setCurrentAsOf(getDefaultDate());
		useType.setUnits(GrossFloorAreaUnitsType.SQUARE_FEET);
		return useType;
	}
	
	private static LengthOfAllOpenClosedRefrigerationUnitsType getDefaultLengthType(){
		LengthOfAllOpenClosedRefrigerationUnitsType useType = new LengthOfAllOpenClosedRefrigerationUnitsType();
		useType.setTemporary(true);
		useType.setValue(BigDecimal.valueOf(0));
		useType.setCurrentAsOf(getDefaultDate());
		useType.setUnits(LengthUnitsType.FEET);
		return useType;
	}
	
	private static CoolingEquipmentRedundancyType getDefaultCoolingEquipmentRedundancyType(){
		CoolingEquipmentRedundancyType useType = new CoolingEquipmentRedundancyType();
		useType.setTemporary(true);
		useType.setValue("None of the Above");
		useType.setCurrentAsOf(getDefaultDate());
		return useType;
	}
	
	private static UpsSystemRedundancyType getDefaultUpsSystemRedundancyType(){
		UpsSystemRedundancyType useType = new UpsSystemRedundancyType();
		useType.setTemporary(true);
		useType.setValue("None of the Above");
		useType.setCurrentAsOf(getDefaultDate());
		return useType;
	}
	
	private static ItEnergyConfigurationType getDefaultItEnergyConfigurationType(){
		ItEnergyConfigurationType useType = new ItEnergyConfigurationType();
		useType.setTemporary(true);
		useType.setValue("Facility Has No UPS");
		useType.setCurrentAsOf(getDefaultDate());
		return useType;
	}
	
	private static OwnedByType getDefaultOwnedByType(){
		OwnedByType useType = new OwnedByType();
		useType.setTemporary(true);
		useType.setValue("For Profit");
		useType.setCurrentAsOf(getDefaultDate());
		return useType;
	}
	
	private static HoursPerDayGuestsOnsiteType getDefaultHoursPerDayGuestsOnsiteType(){
		HoursPerDayGuestsOnsiteType useType = new HoursPerDayGuestsOnsiteType();
		useType.setTemporary(true);
		useType.setValue("Less Than 15");
		useType.setCurrentAsOf(getDefaultDate());
		return useType;
	}
	
	private static AmountOfLaundryProcessedAnnuallyType getDefaultAmountOfLaundryProcessedAnnuallyType(){
		AmountOfLaundryProcessedAnnuallyType useType = new AmountOfLaundryProcessedAnnuallyType();
		useType.setTemporary(true);
		useType.setValue(BigDecimal.valueOf(0));
		useType.setCurrentAsOf(getDefaultDate());
		useType.setUnits(AmountOfLaundryProcessedAnnuallyUnitsType.POUNDS);
		return useType;
	}
	
	private static OnsiteLaundryType getDefaultOnsiteLaundryType(){
		OnsiteLaundryType useType = new OnsiteLaundryType();
		useType.setTemporary(true);
		useType.setValue("No laundry facility");
		useType.setCurrentAsOf(getDefaultDate());
		return useType;
	}
	
	private static MonthsInUseType getDefaultMonthsInUseType(){
		MonthsInUseType useType = new MonthsInUseType();
		useType.setTemporary(true);
		useType.setValue(10);
		useType.setCurrentAsOf(getDefaultDate());
		return useType;
	}
	
	private static ResidentPopulationType getDefaultResidentPopulationType(){
		ResidentPopulationType useType = new ResidentPopulationType();
		useType.setTemporary(true);
		useType.setValue("No specific resident population");
		useType.setCurrentAsOf(getDefaultDate());
		return useType;
	}
	
	private static NumberOfWeekdaysType getDefaultNumberOfWeekdaysType(){
		NumberOfWeekdaysType useType = new NumberOfWeekdaysType();
		useType.setTemporary(true);
		useType.setValue(0);
		useType.setCurrentAsOf(getDefaultDate());
		return useType;
	}
	
	private static PoolSizeType getDefaultPoolSizeType(){
		PoolSizeType useType = new PoolSizeType();
		useType.setTemporary(true);
		useType.setValue("Recreational (20 yards x 15 yards)");
		useType.setCurrentAsOf(getDefaultDate());
		return useType;
	}
	
	private static PoolType getDefaultPoolType(){
		PoolType useType = new PoolType();
		useType.setTemporary(true);
		useType.setValue("Outdoor");
		useType.setCurrentAsOf(getDefaultDate());
		return useType;
	}
	
	private static PlantDesignFlowRateType getDefaultPlantDesignFlowRateType(){
		PlantDesignFlowRateType useType = new PlantDesignFlowRateType();
		useType.setTemporary(true);
		useType.setValue(BigDecimal.valueOf(0));
		useType.setCurrentAsOf(getDefaultDate());
		useType.setUnits(PlantDesignFlowRateUnitsType.MILLION_GALLONS_PER_DAY);
		return useType;
	}
}
