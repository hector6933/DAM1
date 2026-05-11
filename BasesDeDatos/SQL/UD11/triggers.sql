CREATE DEFINER=`root`@`localhost` TRIGGER `triger1` AFTER DELETE ON `country` FOR EACH ROW 
begin

	delete from countryLanguage	where countryCode=old.code;
	
	delete from city where countryCode=old.code;

end