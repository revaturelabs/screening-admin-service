# tech-screening-service

This application is part of the Screenforce MSA. Please refer to to the 
wiki for architectural information and to screenforce-meta for 
environment setup.

## Contribution guidelines

The master branch holds the most recent stable version of the code 
vetted by the product owner. Your trainer will make a PR from your batch 
branch (convention: month and year-trainer name, e.g. 1807-Emily for 
Emily's batch which began in July 2018) into staging after your 
iteration. 

All branches off your batch branch must be prefixed with your batch's 
numeric identifier (e.g. 1807). Stray branches will be deleted. 

The sledgehammer branch is the product owner's own branch, please do not 
use this one. 

##YML
The convention for the YML files:
- The document begins with the Spring declaration to begin with a uniform starting point, with no white space
- All other main lines of the YML file begin with no white space 
- From this intial main line, all following lines will get four additional white spaces
- This process continues for as many additional lines as needed, with each getting an additional four white spaces
- If any comments are added to the YML file then the # should be at the third white space
- Any information for the comment should follow the line spacing listed above, so the # can be removed but the convention remains the same