package com.example.data.mock

import com.example.data.model.DayPlan
import com.example.data.model.MaterialType
import com.example.data.model.QuestionType
import com.example.data.model.RubricCriterion
import com.example.data.model.StudyMaterial
import com.example.data.model.Subject
import com.example.data.model.TUQuestion

object TuCurriculumData {

    val studyMaterials: List<StudyMaterial> = listOf(
        // ======================== YEAR 1 (5 SUBJECTS) ========================
        StudyMaterial(
            id = "eng_mat_01",
            subject = Subject.COMPULSORY_LANGUAGE,
            academicYear = 1,
            type = MaterialType.COURSE_MATERIAL,
            courseCode = "C.Eng. 401",
            title = "Compulsory English I: Academic Reading, Critical Writing & Discourse Analysis",
            nepaliSubtitle = "अनिवार्य अंग्रेजी प्रथम: प्राज्ञिक अध्ययन तथा समालोचनात्मक लेखन",
            authorOrSource = "TU Department of English / Prof. Dr. Shreedhar Gautam",
            estimatedReadMinutes = 40,
            summary = "Foundational 1st Year Compulsory English curriculum: Academic vocabulary, critical textual analysis, rhetoric structures (Expository, Cause-Effect, Argumentative), and formal summary writing for TU examinations.",
            fullContent = """
# Unit 1: Academic English Discourse & Rhetorical Patterns

## 1. Objectives of Compulsory English I (C.Eng. 401)
The 1st Year Compulsory English course aims to equip BA undergraduate students with critical reading, analytical writing, and communicative competence required for academic discourse across humanities and social sciences.

## 2. Key Rhetorical Modes
1. **Expository Writing:** Objectively explaining concepts, definitions, and classification without personal bias.
2. **Cause and Effect Analysis:** Analyzing social causal chains (e.g., agrarian land inequality causing rural underdevelopment and labor migration).
3. **Argumentative & Persuasive Essays:** Structuring a claim, providing empirical evidence, addressing counter-arguments, and synthesizing conclusions.
4. **Summary & Paraphrasing:** Extracting core theses from scholarly articles while avoiding plagiarism and utilizing APA 7th edition referencing standards.

## 3. Sentence Structure & Academic Grammar
* **Cohesion and Coherence:** Effective use of transitional linkers (*furthermore, consequently, notwithstanding, conversely*).
* **Nominalization & Formal Register:** Transforming active informal verbs into academic nouns (*to urbanize → urbanization; to migrate → rural out-migration patterns*).
* **Synthesizing Evidence:** Integrating textual quotes with analytical commentary.
            """.trimIndent(),
            keyTakeaways = listOf(
                "Compulsory English I (100 marks) is mandatory for all 1st Year BA students under TU FOHSS.",
                "Focuses on critical reading comprehension, academic paragraph structures, and argumentative essays.",
                "Mastery of transitional discourse markers is crucial for scoring above 70% in TU English board exams."
            ),
            examKeywords = listOf("Academic Discourse", "Rhetorical Modes", "Cause and Effect", "Paraphrasing", "APA Citation"),
            nepalCaseStudyFocus = "Critical analysis of contemporary essays on Himalayan ecology and development in Nepal.",
            dayPlanMapping = null
        ),

        StudyMaterial(
            id = "rd_mat_01",
            subject = Subject.RURAL_DEVELOPMENT,
            academicYear = 1,
            type = MaterialType.COURSE_MATERIAL,
            courseCode = "RD 421",
            title = "Theories and Concepts of Rural Development",
            nepaliSubtitle = "ग्रामीण विकासका सिद्धान्त र अवधारणाहरू",
            authorOrSource = "Central Dept. of Rural Development, TU / Prof. Dr. Chandra Lal Shrestha",
            estimatedReadMinutes = 45,
            summary = "Comprehensive analysis of classical and contemporary development theories, modernization paradigm, dependency theory, basic human needs, and Amartya Sen's Capability Approach applied to rural Nepal.",
            fullContent = """
# Unit 1: Theories and Concepts of Rural Development

## 1. Introduction to Rural Development
Rural Development is a multi-dimensional strategy designed to improve the economic and social life of a specific group of people—the rural poor. In the context of Nepal, where over 70% of the population resides in rural and semi-urban municipalities, rural development encompasses agricultural modernization, infrastructure expansion, poverty alleviation, institutional building, and empowerment of marginalized groups.

## 2. Key Theoretical Frameworks

### A. Modernization Theory (W.W. Rostow)
* **Five Stages of Growth:** Traditional Society → Preconditions for Take-off → Take-off → Drive to Maturity → Age of High Mass Consumption.
* **Nepalese Context Critique:** Rostow’s linear trajectory assumes industrial capital accumulation that often bypasses geographically fragmented mountain and hill rural economies in Nepal.

### B. Dependency Theory (Andre Gunder Frank, Samir Amin)
* **Core-Periphery Model:** Underdevelopment is not an original state, but an active product of global capitalist relations where resources flow from the periphery (developing countries) to the core (industrial nations).
* **Internal Colonialism in Nepal:** Historical Kathmandu-centric resource concentration prior to federalism reflected internal core-periphery dynamics.

### C. Basic Needs Approach (ILO & World Bank, 1970s)
* Shifts emphasis from pure GDP growth to fulfillment of essential human needs: nutrition, potable drinking water, basic shelter, primary education, and health posts.

### D. Capability Approach (Amartya Sen)
* Development as **Freedom**: Expanding the substantive freedoms and capabilities of individuals to lead the life they value.
* Focuses on agency, voice in local decision-making, and elimination of major sources of unfreedom (poverty, institutional tyranny, neglect of public facilities).

## 3. Sustainable Rural Livelihoods Framework (DFID)
Composed of five vital capital assets:
1. **Human Capital:** Education, indigenous skills, farming knowledge, labor availability.
2. **Natural Capital:** Land tenure, community forests (CFUGs), water sources, biodiversity.
3. **Physical Capital:** Rural roads (Krishi Sadak), suspension bridges, micro-hydropower, irrigation canals.
4. **Financial Capital:** Remittance inflow, cooperatives (Sahakari), micro-credit institutions.
5. **Social Capital:** Guthi systems, Parma (labor-exchange), Women's Saving Groups (Aama Samuha), CFUG committees.

## 4. Key Takeaways for TU BA Examinations
* Always anchor theoretical arguments with concrete Nepali institutions (e.g., Local Government Operation Act 2074, 15th/16th Periodic Plan).
* Distinguish between top-down blueprint approaches versus bottom-up participatory approaches.
            """.trimIndent(),
            keyTakeaways = listOf(
                "Rural development in Nepal requires multidimensional interventions across social, economic, and institutional dimensions.",
                "Amartya Sen's capability approach provides the strongest modern framework for evaluating human development indices in rural Nepal.",
                "DFID's 5 Livelihood Capitals (Human, Natural, Physical, Financial, Social) are mandatory for answering Group C long questions."
            ),
            examKeywords = listOf("Capability Approach", "Dependency Theory", "5 Livelihood Capitals", "Internal Periphery", "Local Government Operation Act 2074"),
            nepalCaseStudyFocus = "Assessment of DFID Livelihood Assets across Karnali Province and Terai Floodplains.",
            dayPlanMapping = 1
        ),

        StudyMaterial(
            id = "rd_mat_02",
            subject = Subject.RURAL_DEVELOPMENT,
            academicYear = 1,
            type = MaterialType.LECTURE_NOTE,
            courseCode = "RD 422",
            title = "Rural Economy of Nepal: Land Tenure, Agrarian Structure & Rural Poverty",
            nepaliSubtitle = "नेपालको भू-स्वामित्व प्रणाली, कृषि संरचना र ग्रामीण गरिबी",
            authorOrSource = "TU FOHSS Lecture Series / Prof. Dr. Bimal Koirala",
            estimatedReadMinutes = 35,
            summary = "Concise examination of historical land tenure systems (Raikar, Birta, Jagir, Guthi, Kipat), Land Reform Act 2021 (1964), land fragmentation, and current agrarian challenges under federal governance.",
            fullContent = """
# Lecture Notes: Agrarian Structure & Land Tenure in Nepal

## 1. Historical Land Systems of Nepal
Prior to the 1951 democratic transition, land tenure in Nepal served as the primary instrument of state patronage and peasant exploitation:
* **Raikar:** State-owned land where cultivators paid revenue directly to the state.
* **Birta:** Land granted by the state/ruler to individuals (usually nobility or priests) as tax-exempt private property.
* **Jagir:** Land assigned to government employees or military officials in lieu of cash salary.
* **Kipat:** Communal customary land ownership practiced primarily among Kirant (Rai and Limbu) communities in Eastern Nepal.
* **Guthi:** Land dedicated to religious, charitable, or cultural institutions.

## 2. Land Reform Act 2021 BS (1964 AD)
* Imposed landholding ceilings (distinct limits for Terai, Kathmandu Valley, and Hills).
* Provisioned tenancy rights (*Mohaiani Haq*) to tenant farmers.
* Abolished Birta and Jimidari intermediaries.
* **Shortcomings:** High political resistance, concealment of excess land via fake family divisions (*Kamaiya/Haruwa-Charuwa* persistence), lack of affordable credit for newly freed tenants.

## 3. Contemporary Agrarian Challenges
1. **Land Fragmentation & Fallowing (*Banjho Jamin*):** Heavy youth labor outmigration to Gulf/Malaysia leaves fertile hill terraces uncultivated.
2. **Feminization of Agriculture:** Over 65% of active farm labor in rural areas is handled by women, yet female formal land ownership remains below 25%.
3. **Dual Tenancy & Sub-optimal Productivity:** Insecurity of sharecropping (*Adhiya/Bataiya*) discourages long-term capital investments in irrigation and soil health.
4. **Policy Interventions:** Land Use Act 2076 (classification of land into 10 categories: agricultural, residential, commercial, industrial, forest, etc.) and contract farming incentives.
            """.trimIndent(),
            keyTakeaways = listOf(
                "Historical land tenures created deep structural inequality that still shapes rural poverty patterns.",
                "Feminization of agriculture is the single most important sociological-economic shift in contemporary rural Nepal.",
                "Land Use Act 2076 aims to curb unmanaged urbanization and preserve arable land."
            ),
            examKeywords = listOf("Mohaiani Haq", "Kipat Tenure", "Feminization of Agriculture", "Land Use Act 2076", "Remittance & Land Fallowing"),
            nepalCaseStudyFocus = "Impact of Land Ceiling and Tenant Rights in Jhapa and Dang Districts.",
            dayPlanMapping = 2
        ),

        StudyMaterial(
            id = "soc_mat_01",
            subject = Subject.SOCIOLOGY,
            academicYear = 1,
            type = MaterialType.COURSE_MATERIAL,
            courseCode = "SOC 421",
            title = "Classical Sociological Thinkers: Marx, Durkheim, Weber & Comte",
            nepaliSubtitle = "शास्त्रीय समाजशास्त्रीय विचारकहरू: मार्क्स, दुर्खिम, वेबर र कोम्त",
            authorOrSource = "TU Central Dept. of Sociology / Prof. Dr. Chaitanya Mishra",
            estimatedReadMinutes = 55,
            summary = "Exhaustive exploration of founding sociological theories: Historical Materialism & Class Struggle (Marx), Social Facts & Anomie (Durkheim), Social Action & Protestant Ethic (Weber), Positivism (Comte).",
            fullContent = """
# Unit 1: Foundations of Classical Sociological Thought

## 1. Auguste Comte (1798–1857): The Father of Sociology
* **Law of Three Stages:**
  1. *Theological Stage:* Supernatural/divine explanations of social reality.
  2. *Metaphysical Stage:* Abstract, philosophical principles rather than deities.
  3. *Positive/Scientific Stage:* Empirical observation, experimentation, and scientific laws governing society.
* Coined the term "Sociology" (1838) and advocated *Social Statics* (order/stability) and *Social Dynamics* (progress/change).

## 2. Karl Marx (1818–1883): Historical Materialism & Conflict Theory
* **Materialist Conception of History:** Economic base determines the superstructure (law, religion, ideology, state).
* **Historical Epochs:** Primitive Communism → Ancient Slave Society → Feudalism → Capitalism → Socialism/Communism.
* **Alienation (*Entfremdung*):** Under capitalism, workers are alienated from product, production process, human essence, and fellow workers.

## 3. Émile Durkheim (1858–1917): Functionalism & Social Facts
* **Social Facts (*Choses Sociales*):** Ways of acting, thinking, and feeling external to the individual, endowed with coercive power.
* **Division of Labor:** Mechanical Solidarity (traditional) vs Organic Solidarity (modern specialized).
* **Study of Suicide (1897):** Egoistic, Altruistic, Anomic, Fatalistic suicide.

## 4. Max Weber (1864–1920): Interpretive Sociology & Rationalization
* **Verstehen:** Empathetic understanding of subjective meaning.
* **The Protestant Ethic and the Spirit of Capitalism (1905):** Calvinist asceticism and capital accumulation.
* **Bureaucracy and Rational-Legal Authority:** Hierarchy, written rules, meritocracy.
            """.trimIndent(),
            keyTakeaways = listOf(
                "Marx views society through the lens of material production and economic class antagonism.",
                "Durkheim established sociology as an empirical discipline studying objective 'Social Facts'.",
                "Weber's 'Verstehen' and ideal types provide the basis for micro-level interpretive sociology."
            ),
            examKeywords = listOf("Historical Materialism", "Social Facts", "Mechanical vs Organic Solidarity", "Verstehen", "Protestant Ethic", "Bureaucracy"),
            nepalCaseStudyFocus = "Applying Marxian and Weberian frameworks to agrarian class dynamics in the Nepalese Terai.",
            dayPlanMapping = 9
        ),

        StudyMaterial(
            id = "soc_mat_02",
            subject = Subject.SOCIOLOGY,
            academicYear = 1,
            type = MaterialType.COURSE_MATERIAL,
            courseCode = "SOC 422",
            title = "Nepalese Social Structure, Caste System & Dor Bahadur Bista's Critique",
            nepaliSubtitle = "नेपाली सामाजिक संरचना, जात व्यवस्था र डोरबहादुर विष्टको विश्लेषण",
            authorOrSource = "TU FOHSS Syllabus Reference / Dor Bahadur Bista & Prof. Ram B. Chhetri",
            estimatedReadMinutes = 45,
            summary = "Sociological investigation of the Muluki Ain 1854 caste hierarchy, Tagadhari-Matawali-Dalit categorization, Sanskritization, and Dor Bahadur Bista's thesis in 'Fatalism and Development'.",
            fullContent = """
# Unit 2: Nepalese Social Structure & Caste Hierarchy

## 1. Codification of Caste: The Muluki Ain of 1854
The 1854 Civil Code enacted by Jung Bahadur Rana institutionalized the Hindu Varna-Jati model across multi-ethnic Nepal:
1. **Tagadhari (Wearers of Holy Cord):** Upadhyaya Brahmin, Rajput, Chhetri.
2. **Matawali (Alcohol-drinking groups):** Namasinyaka (Magar, Gurung, Rai, Limbu, Newar) and Masinyaka (Tamang, Tharu, Chepang).
3. **Pani Na Chalne Chhoi Chhito Halnu Naparne:** Muslims, Christians.
4. **Pani Na Chalne Chhoi Chhito Halnu Parne (Dalits):** Kami, Damai, Sarki, Gaine, Badi in hills; Chamar, Musahar in Terai.

## 2. Dor Bahadur Bista's 'Fatalism and Development' (1991)
* **Fatalism (*Bhagyabad*):** Belief that destiny is preordained by past Karma rather than individual effort and merit.
* **Afno Manchhe Culture:** Prioritization of inner kinship circles over institutional transparency.
* **Chakari System:** Sycophancy toward power-holders to secure jobs and promotions.
* **Devaluation of Physical Labor:** Prestige accorded to non-manual clerical posts.
            """.trimIndent(),
            keyTakeaways = listOf(
                "Muluki Ain 1854 unified diverse ethnic groups under an enforced state-sanctioned caste hierarchy.",
                "Bista's concepts of Fatalism, Afno Manchhe, and Chakari remain central critique points in TU sociology examinations.",
                "Remittance and constitutional provisions are accelerating the disintegration of traditional rural caste dependencies."
            ),
            examKeywords = listOf("Muluki Ain 1854", "Tagadhari & Matawali", "Fatalism and Development", "Afno Manchhe & Chakari", "Sanskritization"),
            nepalCaseStudyFocus = "Caste-based labor transformation and Dalit empowerment in Western Nepal.",
            dayPlanMapping = 10
        ),

        // ======================== YEAR 2 (5 SUBJECTS) ========================
        StudyMaterial(
            id = "nep_mat_01",
            subject = Subject.COMPULSORY_LANGUAGE,
            academicYear = 2,
            type = MaterialType.COURSE_MATERIAL,
            courseCode = "C.Nep. 402",
            title = "Compulsory Nepali: व्याकरण, प्रयोजनपरक नेपाली, समसामयिक निबन्ध र प्रतिवेदन",
            nepaliSubtitle = "अनिवार्य नेपाली: व्यावहारिक तथा प्रशासनिक लेखन शैली",
            authorOrSource = "TU Central Dept. of Nepali / प्रा.डा. माधवप्रसाद पोखरेल",
            estimatedReadMinutes = 40,
            summary = "अनिवार्य नेपाली पाठ्यक्रम: मानक नेपाली वर्णविन्यास, पदवर्ग, वाक्य संश्लेषण र विश्लेषण, प्रशासनिक टिप्पणी तथा प्रतिवेदन लेखन, र नेपालको ग्रामीण विकासमा आधारित समसामयिक निबन्ध।",
            fullContent = """
# अनिवार्य नेपाली (C.Nep. 402) - अध्ययन सामग्री

## १. नेपाली वर्णविन्यास र व्याकरणिक संरचना
* **ह्रस्व-दीर्घ नियम:** तत्सम, तद्भव र आगन्तुक शब्दहरूमा नियमसंगत ह्रस्व-दीर्घ प्रयोग।
* **पदयोग र पदवियोग:** विभक्ति, नामयोगी र समासयुक्त शब्दहरूको शुद्ध लेखन।
* **वाक्य गठन र रूपान्तरण:** सरल, संयुक्त र मिश्र वाक्यको निर्माण तथा वाच्य परिवर्तन।

## २. प्रयोजनपरक नेपाली (प्रशासनिक तथा कानुनी लेखन)
* **टिप्पणी लेखन (Note Writing):** स्थानीय तह (गाउँपालिका/नगरपालिका) मा निर्णय प्रक्रियाका लागि तथ्य, कानुन र सिफारिस सहितको मस्यौदा।
* **सूचना र परिपत्र (Notices & Circulars):** सार्वजनिक जानकारी तथा प्रशासनिक कार्यान्वयनका औपचारिक ढाँचाहरू।
* **माइन्युट लेखन (Minute Writing):** कार्यपालिका तथा उपभोक्ता समितिका बैठकका निर्णय अभिलेखीकरण।

## ३. प्रतिवेदन र समसामयिक निबन्ध लेखन
* **स्थलगत अध्ययन प्रतिवेदन:** शीर्षक, पृष्ठभूमि, उद्देश्य, विधि, निष्कर्ष र सिफारिसको संरचना।
* **विकास निबन्धका प्रमुख विषयहरू:** स्थानीय स्वायत्त शासन, सामुदायिक वन, महिला सशक्तीकरण र विप्रेषण अर्थतन्त्र।
            """.trimIndent(),
            keyTakeaways = listOf(
                "अनिवार्य नेपाली (१०० पूर्णाङ्क) बीए दोस्रो वर्षका सबै विद्यार्थीका लागि अनिवार्य पत्र हो।",
                "प्रशासनिक टिप्पणी, प्रतिवेदन र निबन्ध लेखनमा मानक भाषा शैलीले उच्च अङ्क दिलाउँछ।",
                "स्थानीय सरकार र विकास प्रशासनका शब्दावलीहरूको प्रयोग अनिवार्य हुन्छ।"
            ),
            examKeywords = listOf("वर्णविन्यास", "टिप्पणी लेखन", "प्रयोजनपरक नेपाली", "माइन्युट", "प्रतिवेदन"),
            nepalCaseStudyFocus = "गाउँपालिकाको विकास योजना तर्जुमा सम्बन्धी औपचारिक प्रशासनिक टिप्पणी लेखन।",
            dayPlanMapping = null
        ),

        StudyMaterial(
            id = "rd_mat_04",
            subject = Subject.RURAL_DEVELOPMENT,
            academicYear = 2,
            type = MaterialType.COURSE_MATERIAL,
            courseCode = "RD 423",
            title = "Rural Governance, Decentralization & Local Governance in Federal Nepal (LGOA 2074)",
            nepaliSubtitle = "स्थानीय सरकार सञ्चालन ऐन २०७४ र संघीय नेपालमा स्थानीय शासन",
            authorOrSource = "TU Central Dept. of RD / Dr. Surya Bhakta Pokharel",
            estimatedReadMinutes = 50,
            summary = "In-depth analysis of Schedule 8 of the Constitution of Nepal, Local Government Operation Act 2074 (LGOA), the 7-step bottom-up local planning process, and fiscal federalism.",
            fullContent = """
# Unit 3: Local Governance and Decentralization in Nepal

## 1. Constitutional Architecture of Local Governance
The Constitution of Nepal (2072/2015) established a three-tier federal structure consisting of Federation, Province, and 753 Local Governments (6 Metropolises, 11 Sub-Metropolises, 276 Municipalities, and 460 Rural Municipalities / *Gaunpalikas*).

* **Schedule 8 (Exclusive Local Powers):** 22 distinct exclusive powers including local municipal police, cooperative regulation, basic health & sanitation, basic and secondary education, agriculture and livestock development, local tax collection, and local disaster management.
* **Schedule 9 (Concurrent Powers):** Shared jurisdictions across federal, provincial, and local levels (e.g., electricity, health, social security).

## 2. Local Government Operation Act 2074 (LGOA / स्थानीय सरकार सञ्चालन ऐन २०७४)
Passed to operationalize local autonomy. Key institutional mechanisms:
1. **Executive Powers:** Gaunpalika/Municipality Executive Board headed by Chairperson/Mayor.
2. **Judicial Committee (*Nyayik Samiti*):** 3-member committee chaired by the Deputy Mayor/Vice Chairperson for resolving local civil disputes, boundary disputes, and petty property/nuisance complaints through community mediation.
3. **Ward Committees (*Wada Samiti*):** Grassroots administrative unit ensuring direct citizen interface and targeted scheme formulation.

## 3. The 7-Step Bottom-Up Planning Process (सात दिगो योजना तर्जुमा प्रक्रिया)
To guarantee democratic citizen participation, every local government must follow a mandatory 7-step annual planning cycle:
1. **Step 1: Resource Estimation & Budget Ceiling Determination** (By mid-Poush by Resource Estimation Committee).
2. **Step 2: Selection of Priorities & Guidelines Formulation** (By Executive Board).
3. **Step 3: Settlement/Tole-Level Planning & Need Identification** (Direct citizen assemblies in villages/toles).
4. **Step 4: Ward-Level Project Prioritization & Consolidation** (Ward committee synthesizes tole requests).
5. **Step 5: Budget and Program Formulation Committee Review** (Chaired by Deputy Mayor).
6. **Step 6: Executive Board Approval & Finalization** (Draft budget approved by Executive).
7. **Step 7: Presentation and Endorsement at Village/Municipal Assembly (*Gaun/Nagar Sabha*)** (Mandatory approval by 10th Ashadh).

## 4. Analytical Challenges in Federal Implementation
* **Capacity & Technical Deficits:** Shortage of qualified civil engineers and administrative staff in remote Himalayan/Karnali local governments.
* **Fiscal Dependency:** Over 70% of local budgets rely on federal fiscal equalization and conditional grants (*Samamikaran / Sasharta Anudan*).
            """.trimIndent(),
            keyTakeaways = listOf(
                "Local governments in Nepal are constitutionally autonomous governments, not mere administrative arms.",
                "The 7-step planning process ensures participatory democracy from the Tole level up to the Municipal Assembly.",
                "Judicial Committees under Deputy Mayors provide fast, cost-effective restorative justice."
            ),
            examKeywords = listOf("Schedule 8", "LGOA 2074", "7-Step Planning Process", "Nyayik Samiti", "Fiscal Equalization Grant"),
            nepalCaseStudyFocus = "Participatory budgeting in Hilly Municipalities of Bagmati and Gandaki Provinces.",
            dayPlanMapping = 5
        ),

        StudyMaterial(
            id = "rd_mat_03",
            subject = Subject.RURAL_DEVELOPMENT,
            academicYear = 2,
            type = MaterialType.RESEARCH_PAPER,
            courseCode = "RD 424",
            title = "Natural Resource Management, Community Forestry & Homestay Tourism in Nepal",
            nepaliSubtitle = "नेपालमा सामुदायिक वन, प्राकृतिक स्रोत र ग्रामीण घरबास (होमस्टे) पर्यटन",
            authorOrSource = "Nepal Journal of Social Science and Rural Development / Dr. Hemant Ojha & Dr. Naya Sharma Paudel",
            estimatedReadMinutes = 40,
            summary = "Empirical research paper on the evolution of Community Forest User Groups (CFUGs) under Forest Act 1993, carbon governance, elite capture dynamics, and livelihood benefits from community homestay tourism.",
            fullContent = """
# Research Paper: Community Forestry as a Catalyst for Rural Transformation in Nepal

## Abstract
Nepal's Community Forestry Program is globally celebrated as a pioneering decentralized natural resource management model. Spanning over 22,000 Community Forest User Groups (CFUGs) managing more than 2.3 million hectares of forest, it accounts for both ecological regeneration and local institutional development.

## 1. Historical Evolution
* **Nationalization of Forests (1957 AD):** The Private Forests Nationalization Act alienated local communities, resulting in widespread tragedy of the commons and rapid deforestation.
* **Master Plan for Forestry Sector (1989 AD):** Recognized community participation as the core strategy for ecological revival.
* **Forest Act 1993 & Forest Regulations 1995:** Granted autonomous perpetual corporate status to CFUGs with authority to formulate operational plans and utilize 100% of forest income for local development and forest conservation.

## 2. Socio-Economic Contributions of CFUGs
1. **Local Infrastructure Funding:** CFUG revenues frequently finance rural feeder roads, school teachers' salaries, drinking water pipes, and disaster relief funds.
2. **Democratic Incubation:** Regular executive elections, general assemblies, and mandatory 50% female leadership quotas have groomed thousands of local leaders who now serve in local municipal governments.
3. **Poverty-Targeted Forestry:** Allocation of degraded forest patches to ultra-poor households for non-timber forest products (NTFP) such as broom grass (*Amriso*), cardamom (*Alainchi*), and medicinal herbs (*Chiraito*).

## 3. Community-Based Rural Homestay Tourism
* **Homestay Operating Guidelines 2067 BS:** Promoted indigenous cultural tourism, local organic cuisine, and non-farm income diversification in Sirubari (Syangja) and Ghalegaun (Lamjung).
* **Ecological Co-benefits:** Preservation of traditional architecture and reduction of fuelwood dependency.
            """.trimIndent(),
            keyTakeaways = listOf(
                "Forest Act 1993 transformed local users into autonomous forest custodians with corporate rights.",
                "CFUGs act as primary democratic incubators and social safety nets across rural mid-hills.",
                "Homestay rural tourism provides vital non-agricultural cash flows for rural households."
            ),
            examKeywords = listOf("Forest Act 1993", "CFUG Autonomy", "Elite Capture", "Homestay Guidelines 2067", "LAPA / NAPA"),
            nepalCaseStudyFocus = "Dolakha CFUGs and Ghalegaun Lamjung Rural Homestay Network.",
            dayPlanMapping = 4
        ),

        StudyMaterial(
            id = "soc_mat_05",
            subject = Subject.SOCIOLOGY,
            academicYear = 2,
            type = MaterialType.COURSE_MATERIAL,
            courseCode = "SOC 423",
            title = "Social Stratification, Caste, Class & Gender Inequality in Nepal",
            nepaliSubtitle = "सामाजिक स्तरीकरण, जात, वर्ग र लैंगिक असमानता",
            authorOrSource = "TU Dept. of Sociology / Dr. Youba Raj Luintel & Dr. Surendra Mishra",
            estimatedReadMinutes = 45,
            summary = "Theories of social stratification (Marxist conflict vs Davis-Moore functionalist), intersectionality of caste, class and gender in agrarian Nepal, and Dalit emancipation struggles.",
            fullContent = """
# Unit 1: Social Stratification and Inequality in Nepal

## 1. Theories of Stratification
* **Functionalist Perspective (Kingsley Davis & Wilbert Moore):** Stratification is universal and necessary; society rewards functionally vital positions with prestige and high income to ensure talent allocation.
* **Conflict Perspective (Karl Marx):** Stratification is rooted in private ownership of means of production (*Bourgeoisie vs Proletariat*), creating exploitation and alienation.
* **Multidimensional Stratification (Max Weber):** Class (economic), Status (social prestige), and Party (political power).

## 2. Caste-Class Intersectionality in Nepal
* **Cumulative Inequality:** In traditional rural Nepal, high caste status coincided with land ownership and political authority, while Dalits suffered economic dispossession and ritual untouchability.
* **Dispersed Inequality in Modern Era:** Remittances and education are allowing lower castes to achieve economic wealth, though social discrimination persists.
* **Patriarchy & Legal Reforms:** Constitution of Nepal 2072 Article 38 (Equal lineage and property rights for women).
            """.trimIndent(),
            keyTakeaways = listOf(
                "Stratification in Nepal is an interplay between hereditary caste status and evolving class dynamics.",
                "Marxian and Weberian frameworks must be applied together to analyze contemporary rural inequality.",
                "Constitutional quotas (Article 84) aim to redress historical structural marginalization."
            ),
            examKeywords = listOf("Davis-Moore Thesis", "Cumulative Inequality", "Intersectionality", "Patriarchy in Nepal", "Dalit Emancipation"),
            nepalCaseStudyFocus = "Changing caste-class relations in Madhesh and Far-Western Nepal.",
            dayPlanMapping = 11
        ),

        StudyMaterial(
            id = "soc_mat_06",
            subject = Subject.SOCIOLOGY,
            academicYear = 2,
            type = MaterialType.COURSE_MATERIAL,
            courseCode = "SOC 424",
            title = "Social Movements, Ethnicity, Janajati & Madhesh Struggles in Nepal",
            nepaliSubtitle = "नेपालमा सामाजिक आन्दोलन, जनजाति र मधेस आन्दोलनको समाजशास्त्र",
            authorOrSource = "TU Dept. of Sociology / Dr. Krishna B. Bhattachan",
            estimatedReadMinutes = 45,
            summary = "Sociological theories of social movements (Relative Deprivation, Resource Mobilization), Adivasi Janajati identity mobilization, NEFIN's role, Madhesh autonomy struggles, and state restructuring.",
            fullContent = """
# Unit 2: Social Movements and Identity Politics in Nepal

## 1. Theories of Social Movements
* **Relative Deprivation Theory (Gurr):** Mobilization occurs when individuals perceive a discrepancy between their value expectations and value capabilities.
* **Resource Mobilization Theory (McCarthy & Zald):** Movements succeed through organizational infrastructure, elite alliances, and communication networks.

## 2. The Adivasi Janajati Movement (आदिवासी जनजाति आन्दोलन)
* **Historical Grievance:** Assimilationist policies (*Eka Bhasha, Eka Bhesh*) during the Panchayat regime.
* **Key Demands:** Linguistic equality, proportional representation, secular state, and self-determination under ILO Convention 169.
* **NEFIN (नेपाल आदिवासी जनजाति महासंघ):** Umbrella organizational body coordinating 59 recognized indigenous nationalities.

## 3. The Madhesh Movement (मधेश आन्दोलन)
* 2007, 2008, and 2015 mass mobilizations demanding federal boundary demarcation, proportional inclusion in civil service/security forces, and citizenship equality.
            """.trimIndent(),
            keyTakeaways = listOf(
                "Social movements in Nepal transformed a unitary Hindu kingdom into a secular federal democratic republic.",
                "Relative deprivation theory best explains the ethnic assertions of post-1990 Nepal.",
                "Proportional representation and federalism were direct outcomes of grassroots identity movements."
            ),
            examKeywords = listOf("Relative Deprivation", "Adivasi Janajati", "ILO Convention 169", "NEFIN", "Madhesh Movement"),
            nepalCaseStudyFocus = "Ethnic and regional identity mobilization across Eastern and Central Terai.",
            dayPlanMapping = 12
        ),

        // ======================== YEAR 3 (5 SUBJECTS) ========================
        StudyMaterial(
            id = "nepst_mat_01",
            subject = Subject.COMPULSORY_LANGUAGE,
            academicYear = 3,
            type = MaterialType.COURSE_MATERIAL,
            courseCode = "C.NepSt. 403",
            title = "Compulsory Nepal Studies: Geography, Political Transformation & Foreign Relations",
            nepaliSubtitle = "अनिवार्य नेपाल अध्ययन: भूगोल, इतिहास, संस्कृति, अर्थतन्त्र र परराष्ट्र नीति",
            authorOrSource = "TU FOHSS Interdisciplinary Series / Dr. Rajesh Gautam",
            estimatedReadMinutes = 45,
            summary = "Comprehensive 3rd Year Compulsory curriculum: Nepal's geo-strategic location, political milestones from unification to 2072 Constitution, socio-cultural pluralism, natural resources, and non-aligned foreign policy (Panchasheel).",
            fullContent = """
# Unit 1: Foundations of Nepal Studies (नेपाल अध्ययन)

## 1. Geo-Strategic & Physical Dimensions
* **Ecological Belts:** Mountain (Himal), Hill (Pahad), and Lowland Terai (Madhesh), representing extreme altitudinal diversity (60m to 8848.86m).
* **Geopolitics:** Land-linked buffer state between two Asian giants (India and China), requiring balanced strategic diplomacy (*Yam between Two Boulders*).

## 2. Key Political Transformations
* **Unification Period (1768 AD):** Prithvi Narayan Shah's state consolidation.
* **Democratic Milestones:** 1951 (2007 BS End of Rana Regime), 1990 (2047 BS Restoration of Multiparty Democracy), and 2006 (2062/63 BS People's Movement).
* **Federal Democratic Republic (2015/2072 BS Constitution):** Institutionalization of secularism, federalism, and fundamental human rights.

## 3. Nepalese Economy & Foreign Policy
* **Economic Drivers:** Agriculture, hydropower potential (~83,000 MW theoretical), foreign tourism, and foreign employment remittances.
* **Foreign Policy Principles:** Non-alignment (NAM), UN Charter, peaceful coexistence, and *Panchasheel* principles.
            """.trimIndent(),
            keyTakeaways = listOf(
                "Compulsory Nepal Studies provides an essential holistic framework for understanding development and society.",
                "Nepal's geopolitical vulnerability necessitates strict adherence to non-alignment and Panchasheel.",
                "Constitutional federalism is the culmination of historical political democratic struggles."
            ),
            examKeywords = listOf("Geopolitics", "Panchasheel", "Non-Aligned Movement", "Federal Constitution 2072", "Hydropower Potential"),
            nepalCaseStudyFocus = "Nepal-India and Nepal-China transit trade agreements and economic diplomacy.",
            dayPlanMapping = null
        ),

        StudyMaterial(
            id = "rd_mat_05",
            subject = Subject.RURAL_DEVELOPMENT,
            academicYear = 3,
            type = MaterialType.COURSE_MATERIAL,
            courseCode = "RD 425",
            title = "Rural Development Planning, Project Cycle Management (PCM) & PRA Tools",
            nepaliSubtitle = "ग्रामीण विकास योजना, आयोजना चक्र व्यवस्थापन र सहभागितामूलक विधि (लगफ्रेम)",
            authorOrSource = "Central Dept. of RD, TU / Dr. Umakant Silwal",
            estimatedReadMinutes = 50,
            summary = "Mastery of Project Cycle Management (PCM), Logical Framework Approach (LogFrame matrix, OVIs, MOVs, assumptions), PRA field tools (Transect Walk, Venn Diagram, Seasonal Calendar), and Impact Evaluation.",
            fullContent = """
# Unit 1: Project Cycle Management & Logical Framework Approach

## 1. The Project Life Cycle
1. **Identification:** Needs assessment, stakeholder analysis, and Problem Tree analysis (*Cause-Effect Relationship*).
2. **Formulation / Design:** Transforming problem tree into Objective Tree and designing the Logical Framework Matrix.
3. **Appraisal & Approval:** Technical, financial, economic, environmental, and social feasibility studies.
4. **Implementation:** Work breakdown structure (Gantt Chart), resource mobilization, and procurement.
5. **Monitoring & Evaluation (M&E):** On-going formative tracking vs terminal summative impact evaluation.

## 2. Logical Framework Matrix (LogFrame - 4x4 Matrix)
* **Narrative Summary:** Goal → Purpose (Outcome) → Outputs → Activities.
* **Objectively Verifiable Indicators (OVIs):** SMART indicators (Specific, Measurable, Achievable, Relevant, Time-bound).
* **Means of Verification (MOVs):** Data sources (e.g., municipal survey, project audit reports).
* **Assumptions & Risks:** External conditions beyond project control necessary for success.

## 3. Participatory Rural Appraisal (PRA) Field Tools
* **Transect Walk:** Systematic walk with villagers across ecological zones to observe land use and soil conditions.
* **Venn Diagram (Chapati Diagram):** Institutional mapping showing influence and accessibility of rural organizations.
* **Seasonal Calendar:** Graphing seasonal agricultural labor peaks, food deficits, disease outbreaks, and migration cycles.
            """.trimIndent(),
            keyTakeaways = listOf(
                "Logical Framework Matrix is the single most tested tool in TU RD examinations.",
                "Problem Tree formulation is mandatory for deriving project objectives.",
                "PRA tools empower rural communities to own their development solutions."
            ),
            examKeywords = listOf("LogFrame Matrix", "Problem Tree", "OVIs & MOVs", "Transect Walk", "Venn Diagram"),
            nepalCaseStudyFocus = "Design of a Rural Drinking Water and Sanitation LogFrame in Gorkha District.",
            dayPlanMapping = 6
        ),

        StudyMaterial(
            id = "rd_mat_06",
            subject = Subject.RURAL_DEVELOPMENT,
            academicYear = 3,
            type = MaterialType.COURSE_MATERIAL,
            courseCode = "RD 426",
            title = "Microfinance, Cooperatives & Rural Livelihoods in Nepal",
            nepaliSubtitle = "लघुवित्त, सहकारी र ग्रामीण जीविकोपार्जन (सहकारी ऐन २०७४)",
            authorOrSource = "TU FOHSS / Dr. Dilli Ram Dahal",
            estimatedReadMinutes = 40,
            summary = "Evaluation of Nepal's 3-pillar economy, Cooperative Act 2074, Grameen group-lending methodology, women's micro-enterprises, over-indebtedness challenges, and Nepal Rastra Bank regulatory guidelines.",
            fullContent = """
# Unit 2: Rural Financial Institutions & Cooperative Architecture

## 1. The Cooperative Sector in Nepal
* **Constitutional Role:** The Constitution recognizes the Cooperative sector as one of the three pillars of the national economy (Public, Private, Cooperative).
* **Cooperative Act 2074 (सहकारी ऐन २०७४):** Decentralized regulation of cooperatives operating within a single municipality to the local Palika government.
* **Types:** Saving & Credit (SACCOs), Agricultural Cooperatives (*Krishi Sahakari*), Dairy, Consumer, and Multi-purpose Cooperatives.

## 2. Microfinance Group Lending Model
* **Grameen Model Replication:** Collateral-free group liability (*Samuhik Jamanat*), weekly center meetings, and compulsory small savings.
* **Poverty Alleviation Impact:** Financing goat rearing, poultry, vegetable poly-houses, and small retail shops.
* **Crisis & Regulatory Intervention:** Multiple borrowing (*Dohoro Rin*), predatory recovery tactics, and NRB directives capping interest rates and loan ceilings.
            """.trimIndent(),
            keyTakeaways = listOf(
                "Cooperatives are the financial backbone of agrarian villages in Nepal.",
                "Microfinance has unlocked unprecedented financial inclusion for rural women.",
                "Regulatory tightening by NRB and Palikas is critical to prevent over-indebtedness."
            ),
            examKeywords = listOf("Cooperative Act 2074", "Three-Pillar Economy", "Grameen Model", "Multiple Borrowing", "SACCOs"),
            nepalCaseStudyFocus = "Women-led agricultural saving cooperatives in Kavrepalanchok District.",
            dayPlanMapping = 3
        ),

        StudyMaterial(
            id = "soc_mat_04",
            subject = Subject.SOCIOLOGY,
            academicYear = 3,
            type = MaterialType.LECTURE_NOTE,
            courseCode = "SOC 425",
            title = "Social Science Research Methodology: Qualitative & Quantitative Methods",
            nepaliSubtitle = "सामाजिक विज्ञान अनुसन्धान विधि: गुणात्मक र परिमाणात्मक विधिहरू",
            authorOrSource = "TU FOHSS Research Wing / Dr. Ram Kumar Sharma",
            estimatedReadMinutes = 35,
            summary = "Essential research toolkit for BA students: Research design, sampling techniques (probability vs non-probability), PRA tools, Focus Group Discussions (FGD), Key Informant Interviews (KII), and Triangulation.",
            fullContent = """
# Lecture Notes: Research Methodology in Sociology & Rural Development

## 1. The Research Process
1. Selection & Formulation of Research Problem
2. Literature Review
3. Hypothesis / Research Questions
4. Research Design (Exploratory, Descriptive, Explanatory)
5. Sampling Design
6. Data Collection (Primary & Secondary)
7. Data Analysis & Interpretation
8. Report Writing (APA 7th Edition)

## 2. Sampling Techniques
* **Probability Sampling:** Simple Random, Stratified, Cluster, Systematic.
* **Non-Probability Sampling:** Purposive, Snowball, Quota, Convenience.

## 3. Qualitative Tools for Rural Fieldwork
* **Key Informant Interview (KII)**
* **Focus Group Discussion (FGD)**
* **Participant Observation (*Sahabhagimulak Awolokan*)**
* **PRA Tools:** Social Map, Resource Map, Seasonal Calendar, Venn Diagram, Pairwise Ranking.

## 4. Triangulation (*Tribhujikaran*)
Using multiple methods, data sources, observers, or theories to validate research findings.
            """.trimIndent(),
            keyTakeaways = listOf(
                "Research methodology is compulsory for both Rural Development and Sociology papers in TU exams.",
                "Triangulation ensures validity and reliability by cross-verifying qualitative and quantitative findings.",
                "Always mention Nepal fieldwork tools like KII, FGD, and PRA Venn diagrams in exam answers."
            ),
            examKeywords = listOf("Triangulation", "Stratified Sampling", "PRA Tools", "Key Informant Interview (KII)", "Focus Group Discussion (FGD)"),
            nepalCaseStudyFocus = "Fieldwork methodology applied in indigenous Chepang communities of Makwanpur.",
            dayPlanMapping = 13
        ),

        StudyMaterial(
            id = "soc_mat_07",
            subject = Subject.SOCIOLOGY,
            academicYear = 3,
            type = MaterialType.COURSE_MATERIAL,
            courseCode = "SOC 426",
            title = "Family, Marriage, Kinship & Demography in Nepal (Census 2078)",
            nepaliSubtitle = "परिवार, विवाह, नातागोता र जनसांख्यिकी (राष्ट्रिय जनगणना २०७८)",
            authorOrSource = "TU Dept. of Sociology / Dr. Padam Lal Devkota",
            estimatedReadMinutes = 45,
            summary = "Structural analysis of marriage forms in Nepal (Monogamy, Fraternal Polyandry in Himalayan regions, Cross-Cousin marriage), Patrilineal descent, Guthi networks, and National Population Census 2078 demographics.",
            fullContent = """
# Unit 3: Kinship Systems and Demographic Transitions in Nepal

## 1. Forms of Marriage in Multi-Ethnic Nepal
* **Fraternal Polyandry (दाजुभाइ बहुपति प्रथा):** Practiced historically in high-altitude Himalayan communities (Dolpo, Humla, Mustang) to prevent agricultural land fragmentation and adapt to high-altitude pastoralism.
* **Cross-Cousin Marriage (मामा-चेली / फुपु-चेला विवाह):** Preferred institutional marriage among Gurung, Magar, and Thakali communities.
* **Arranged vs Elopement (*Bagiya Vivaha*):** Shift towards love-cum-arranged marriages with rising education and mobile technology.

## 2. Kinship Networks and Social Capital
* **Lineage (*Kula*) & Clan (*Gotra*):** Exogamy and ritual pollution rules (*Jutho/Sutak*).
* **Guthi System of the Newars:** Religious, socio-cultural, and death guthi (*Si Guthi*) managing communal public goods and festivals.

## 3. Demographic Realities (National Census 2078 BS / 2021 AD)
* **Population:** 29,164,578 with an annual growth rate of 0.92%.
* **Urbanization:** Over 66% living in designated urban municipalities (though often lacking metropolitan infrastructure).
* **Household Size:** Decreased to 4.37 persons, confirming nuclearization of families.
            """.trimIndent(),
            keyTakeaways = listOf(
                "Fraternal polyandry is an ecological adaptation to extreme resource scarcity in high Himalayas.",
                "Census 2078 confirms significant demographic shifts: fertility decline and rapid urban migration.",
                "The Newar Guthi system is one of the world's most enduring indigenous social institutions."
            ),
            examKeywords = listOf("Fraternal Polyandry", "Cross-Cousin Marriage", "Guthi System", "Census 2078", "Demographic Dividend"),
            nepalCaseStudyFocus = "Kinship survival strategies among Tibetan-speaking pastoralists of Upper Mustang.",
            dayPlanMapping = 14
        ),

        // ======================== YEAR 4 (5 SUBJECTS) ========================
        StudyMaterial(
            id = "eng_mat_02",
            subject = Subject.COMPULSORY_LANGUAGE,
            academicYear = 4,
            type = MaterialType.COURSE_MATERIAL,
            courseCode = "C.Eng. 404",
            title = "Academic Writing & Applied Social Research: Proposal, Literature Review & Monograph",
            nepaliSubtitle = "प्राज्ञिक लेखन तथा व्यावहारिक सामाजिक अनुसन्धान",
            authorOrSource = "TU Department of English / Dr. Beerendra Pandey",
            estimatedReadMinutes = 45,
            summary = "Advanced 4th Year academic writing curriculum: Structuring research proposals, literature review synthesis, academic voice & hedging, APA 7th referencing standards, and preparing thesis manuscripts.",
            fullContent = """
# Unit 1: Scholarly Writing & Research Proposal Architecture

## 1. Anatomy of an Academic Research Paper (IMRaD Format)
* **Title & Abstract:** Concise formulation of problem, methodology, key findings, and policy implications.
* **Introduction:** Contextualization, statement of research problem, research questions, and theoretical significance.
* **Literature Review:** Thematic synthesis and identifying scholarly knowledge gaps (*not an annotated bibliography*).
* **Methodology:** Explicit detailing of research design, sample selection, tools, ethical considerations, and limitations.
* **Findings & Discussion:** Triangulation of empirical data with established theoretical paradigms.
* **Conclusion & Recommendations:** Actionable policy takeaways for local governments and development actors.

## 2. Academic Register, Tone & Ethics
* **Hedging (*Cautious Language*):** Using modal qualifiers (*suggests, indicates, appears to demonstrate*) rather than absolute claims.
* **Avoiding Plagiarism:** Direct quotes vs paraphrasing with proper in-text author-date citations (APA 7th).
* **Software Tools:** Introduction to Zotero and Mendeley for bibliographic management.
            """.trimIndent(),
            keyTakeaways = listOf(
                "Academic writing is compulsory for completing the 4th Year research monograph.",
                "Literature review must synthesize thematic debates rather than merely summarizing isolated books.",
                "Mastery of APA 7th citation is mandatory for scoring high in the 4th Year paper."
            ),
            examKeywords = listOf("IMRaD Format", "Literature Synthesis", "Hedging", "APA 7th Style", "Research Proposal"),
            nepalCaseStudyFocus = "Drafting a formal research proposal on climate adaptation in Karnali River Basin.",
            dayPlanMapping = null
        ),

        StudyMaterial(
            id = "rd_mat_07",
            subject = Subject.RURAL_DEVELOPMENT,
            academicYear = 4,
            type = MaterialType.COURSE_MATERIAL,
            courseCode = "RD 427",
            title = "Gender, Social Inclusion (GESI) & Human Development in Nepal",
            nepaliSubtitle = "लैंगिक समानता, सामाजिक समावेशीकरण र मानव विकास (जीईएसआई)",
            authorOrSource = "Central Dept. of RD, TU / Dr. Bina Pradhan & Dr. Chandra Lal Shrestha",
            estimatedReadMinutes = 45,
            summary = "Evolution of gender paradigms (WID, WAD, GAD), Gender Responsive Budgeting (GRB) in federal, provincial and local budgets, Human Development Index (HDI), and Nepal's LDC Graduation roadmap.",
            fullContent = """
# Unit 1: Gender Equality and Social Inclusion (GESI) Framework

## 1. Evolution of Gender and Development Paradigms
* **Women in Development (WID - 1970s):** Focused on adding women into existing development projects without challenging structural unequal power relations.
* **Women and Development (WAD - Late 1970s):** Argued that women have always been part of development processes; highlighted global inequalities.
* **Gender and Development (GAD - 1980s onward):** Analyzes socially constructed gender roles, power dynamics, and patriarchal structures.

## 2. Gender Responsive Budgeting (GRB - लैंगिक उत्तरदायी बजेट)
* Initiated in Nepal in FY 2064/65 (2007/08) with 3 categories: Directly Gender Responsive (>50%), Indirectly Responsive (20–50%), and Neutral (<20%).
* **Local Palika GRB Auditing:** Ensuring women and marginalized groups directly influence municipal capital expenditure.

## 3. Nepal's Human Development and LDC Graduation
* **LDC Graduation by 2026:** Fulfilling GNI per capita, Human Assets Index (HAI), and Economic & Environmental Vulnerability Index (EVI).
* **16th Periodic Plan (2081/82–2085/86):** Good governance, social justice, and prosperity.
            """.trimIndent(),
            keyTakeaways = listOf(
                "GAD paradigm requires transformative restructuring of household and state power relations.",
                "Gender Responsive Budgeting is a mandatory policy instrument in Nepal's local governance.",
                "Nepal's LDC graduation in 2026 demands urgent human capital investment."
            ),
            examKeywords = listOf("WID WAD GAD", "Gender Responsive Budgeting (GRB)", "LDC Graduation 2026", "HDI & GII", "16th Periodic Plan"),
            nepalCaseStudyFocus = "Application of GRB scoring across selected Rural Municipalities of Lumbini Province.",
            dayPlanMapping = 7
        ),

        StudyMaterial(
            id = "rd_mat_08",
            subject = Subject.RURAL_DEVELOPMENT,
            academicYear = 4,
            type = MaterialType.COURSE_MATERIAL,
            courseCode = "RD 428",
            title = "Rural Practicum, 30-Day Palika Field Placement & Project Monograph Guidelines",
            nepaliSubtitle = "ग्रामीण प्रयोगात्मक कार्य, ३० दिने स्थलगत इन्टर्नसिप र शोध प्रतिवेदन",
            authorOrSource = "TU FOHSS Practicum Committee / Prof. Dr. Chandra Lal Shrestha",
            estimatedReadMinutes = 40,
            summary = "Step-by-step guidebook for the mandatory 4th Year RD 30-day field practicum: Coordination with Rural Municipalities, PRA tools execution, institutional study of Ward and Executive, and viva-voce preparation.",
            fullContent = """
# Unit 2: Practicum Execution & Field Monograph Guidelines

## 1. Practicum Objectives
The 4th Year Practicum (RD 428) is an applied 100-mark paper requiring 30 continuous days of field placement in a designated Rural Municipality (*Gaunpalika*) or Municipality (*Nagarpalika*).

## 2. Fieldwork Core Tasks
1. **Institutional Profiling:** Analyzing the organogram, staffing, revenue sources, and annual budget of the host Palika.
2. **Community PRA Execution:** Conducting Transect Walk, Social Map, and Venn Diagram in a marginalized ward.
3. **Problem Tree Formulation:** Identifying a core grassroots development bottleneck (e.g., irrigation canal collapse, high school dropout rate).
4. **Mini Project Formulation:** Preparing a detailed project proposal with LogFrame and budget.

## 3. Report Submission & Viva-Voce Defense
* Standard TU thesis structure: Chapter 1 (Introduction), Chapter 2 (Palika Profile), Chapter 3 (Field Methodology), Chapter 4 (Community Findings & PRA), Chapter 5 (Mini Project Proposal), Chapter 6 (Conclusions & Recommendations).
* Oral defense before external examiner appointed by TU Examination Board.
            """.trimIndent(),
            keyTakeaways = listOf(
                "RD 428 bridges academic theory with authentic local governance administration.",
                "Field report must include original PRA maps and municipal data collected on site.",
                "Passing the viva-voce is mandatory for graduation in the double-major BA program."
            ),
            examKeywords = listOf("Palika Placement", "Field Practicum", "Viva-Voce Defense", "Institutional Profile", "Mini Project Proposal"),
            nepalCaseStudyFocus = "Field placement sample report from a Gaunpalika in Dhading District.",
            dayPlanMapping = 8
        ),

        StudyMaterial(
            id = "soc_mat_03",
            subject = Subject.SOCIOLOGY,
            academicYear = 4,
            type = MaterialType.RESEARCH_PAPER,
            courseCode = "SOC 427",
            title = "Sociology of Globalization, Transnational Migration & Remittance in Nepal",
            nepaliSubtitle = "भूमण्डलीकरण, वैदेशिक रोजगारी, विप्रेषण र नेपाली परिवारको रूपान्तरण",
            authorOrSource = "Social Science Baha & TU Department of Sociology / Dr. Ganesh Gurung & Dr. Susan Thieme",
            estimatedReadMinutes = 40,
            summary = "Sociological analysis of Gulf/East Asian labor migration trends, remittance contribution to GDP (~25-30%), transformation from joint to nuclear families, and the rise of female-headed rural households.",
            fullContent = """
# Research Paper: The Sociology of Remittance and Kinship Transformation in Nepal

## 1. Macro Context of Nepalese Migration
* **Remittance Volume:** Inflow constitutes roughly 24–30% of Nepal's GDP annually.
* **Destination Shift:** Beyond India (*Muglan*), contemporary migration flows to Qatar, Saudi Arabia, UAE, Malaysia, Japan, and South Korea.

## 2. Impacts on Family Structure & Kinship
1. **Transition to Nuclear (*Ekak*) Families:** Younger married couples purchase homesteads in peri-urban market centers.
2. **De-facto Female Headship:** Women manage finances, agriculture, children's schooling, and health decisions.
3. **The 'Left-Behind' Paradox:** Elderly grandparents sole caregivers in rural hill villages.
4. **Shifts in Social Prestige:** Wealth acquired through foreign labor challenges hereditary feudal hierarchies.
            """.trimIndent(),
            keyTakeaways = listOf(
                "Remittance in Nepal is a profound sociological transformer of rural kinship.",
                "The rise of female-headed households is redefining gender roles in rural decision-making.",
                "Sociological examination questions frequently ask students to evaluate both economic benefits and social costs."
            ),
            examKeywords = listOf("Transnational Migration", "De-facto Female Headship", "Left-Behind Population", "Social Remittances", "Nuclearization of Family"),
            nepalCaseStudyFocus = "Socio-cultural impacts of Gulf migration on Magar and Gurung villages in Western Hills.",
            dayPlanMapping = 15
        ),

        StudyMaterial(
            id = "soc_mat_08",
            subject = Subject.SOCIOLOGY,
            academicYear = 4,
            type = MaterialType.COURSE_MATERIAL,
            courseCode = "SOC 428",
            title = "Academic Thesis / Research Monograph in Sociology: Fieldwork to Dissertation",
            nepaliSubtitle = "समाजशास्त्रमा शोधपत्र / अनुसन्धान मोनोग्राफ: स्थलगत कार्यदेखि शोध प्रतिवेदनसम्म",
            authorOrSource = "TU Dept. of Sociology / Prof. Dr. Chaitanya Mishra & Prof. Ram B. Chhetri",
            estimatedReadMinutes = 45,
            summary = "Comprehensive dissertation manual for BA 4th Year Sociology students: Selecting sociological research problems, primary field data collection ethics, qualitative coding, thesis formatting, and external viva defense.",
            fullContent = """
# Unit 3: Sociological Dissertation Methodology & Defense

## 1. Stages in Sociological Dissertation
1. **Topic Formulation:** Identifying a sociologically relevant research question (e.g., changes in inter-caste dining habits, elderly care deficits in migrant households).
2. **Theoretical Grounding:** Framing the study within Conflict, Functionalist, Symbolic Interactionist, or Feminist paradigms.
3. **Primary Fieldwork:** In-depth semi-structured interviews, participant observation, and case studies.
4. **Thematic Coding:** Categorizing qualitative narratives into analytical codes and sub-themes.

## 2. Dissertation Architecture
* **Chapter 1:** Introduction, Problem Statement, Objectives, Significance.
* **Chapter 2:** Literature Review & Conceptual Framework.
* **Chapter 3:** Research Methodology (Setting, Sample, Tools, Ethical Consent).
* **Chapter 4:** Socio-Demographic Setting of the Study Area.
* **Chapter 5 & 6:** Thematic Data Analysis & Sociological Discussion.
* **Chapter 7:** Summary, Conclusions & Recommendations.

## 3. Viva-Voce Examination
* Oral defense before the Departmental Research Committee and External Examiner appointed by TU.
            """.trimIndent(),
            keyTakeaways = listOf(
                "SOC 428 thesis provides empirical rigor and preparation for Master's level research.",
                "Qualitative primary narratives must be contextualized with sociological theory.",
                "Adherence to ethical informed consent and confidentiality is mandatory."
            ),
            examKeywords = listOf("Sociological Dissertation", "Thematic Coding", "Viva-Voce Defense", "Qualitative Narratives", "Informed Consent"),
            nepalCaseStudyFocus = "Sample sociological monograph on elderly care in rural Parbat District.",
            dayPlanMapping = 16
        )
    )

    val sixteenDayPlans: List<DayPlan> = listOf(
        DayPlan(
            dayNumber = 1,
            subject = Subject.RURAL_DEVELOPMENT,
            title = "Day 1: Classical & Modern Theories of Rural Development",
            subtitle = "Rostow, Dependency Theory, Capability Approach & Basic Needs",
            targetMinutes = 60,
            unitName = "RD Unit 1: Foundations & Paradigms",
            overview = "Master the evolution of development paradigms from economic growth models to human-centered capability approaches in Nepal.",
            coreTopics = listOf(
                "Definition, scope, and objectives of Rural Development in Nepal",
                "W.W. Rostow's Linear Growth Model and its limitations in developing hill economies",
                "Dependency Theory (Core-Periphery & Internal Colonialism)",
                "Amartya Sen's Capability Approach: Development as Freedom",
                "DFID Sustainable Livelihood Framework (5 Capitals)"
            ),
            materialIds = listOf("rd_mat_01"),
            primaryQuestionId = "tu_q_rd_01",
            tuExamTip = "In 10-mark questions, always draw the Core-Periphery diagram or the 5 Livelihood Capitals pentagon to secure higher marks."
        ),
        DayPlan(
            dayNumber = 2,
            subject = Subject.RURAL_DEVELOPMENT,
            title = "Day 2: Agrarian Structure, Land Reform & Rural Poverty",
            subtitle = "Land Tenure Systems, Land Reform Act 2021 & Feminization of Agriculture",
            targetMinutes = 60,
            unitName = "RD Unit 2: Agrarian Dynamics & Land Systems",
            overview = "Understand historical land tenures (Raikar, Birta, Kipat, Guthi), tenancy rights, land fragmentation, and contemporary agrarian crises.",
            coreTopics = listOf(
                "Historical land tenure systems: Raikar, Birta, Jagir, Kipat, and Guthi",
                "Land Reform Act 2021 BS: Achievements, loopholes, and failure of ceiling enforcement",
                "Land fragmentation and fallow land (*Banjho Jamin*) due to foreign employment",
                "Feminization of agriculture and land ownership disparity in rural Nepal",
                "Land Use Act 2076 and contract farming prospects"
            ),
            materialIds = listOf("rd_mat_02"),
            primaryQuestionId = "tu_q_rd_02",
            tuExamTip = "Mention specific legal acts like 'Land Reform Act 2021' and 'Land Use Act 2076' with exact dates and provisions."
        ),
        DayPlan(
            dayNumber = 3,
            subject = Subject.RURAL_DEVELOPMENT,
            title = "Day 3: Rural Institutions, Cooperatives & Microfinance",
            subtitle = "Cooperative Act 2074, Financial Inclusion & Rural Livelihoods",
            targetMinutes = 60,
            unitName = "RD Unit 3: Rural Finance & Institutional Framework",
            overview = "Explore the role of 3-pillar economic strategy, savings and credit cooperatives (SACCOs), microfinance institutions, and rural indebtedness.",
            coreTopics = listOf(
                "Three-pillar economy of Nepal (Public, Private, and Cooperative sectors)",
                "Cooperative Act 2074: Principles and regulatory oversight by Local Governments",
                "Microfinance institutions (MFIs) as drivers of women's entrepreneurship",
                "Over-indebtedness issues (*Laghubitta Pidit*) and regulatory reforms by NRB",
                "Traditional informal institutions: Dhukuti, Parma, and Bheja systems"
            ),
            materialIds = listOf("rd_mat_01", "rd_mat_02"),
            primaryQuestionId = "tu_q_rd_03",
            tuExamTip = "Discuss both positive empowerment aspects and recent regulatory controversies surrounding microfinance in rural Nepal."
        ),
        DayPlan(
            dayNumber = 4,
            subject = Subject.RURAL_DEVELOPMENT,
            title = "Day 4: Natural Resource Management & Community Forestry",
            subtitle = "Forest Act 1993, CFUGs, Water Resource & Climate Adaptation",
            targetMinutes = 60,
            unitName = "RD Unit 4: Environment & Resource Governance",
            overview = "Deep dive into Nepal's globally acclaimed Community Forestry model, Forest Act 1993, elite capture, and local watershed management.",
            coreTopics = listOf(
                "Forest Nationalization Act 1957 vs Community Forestry under Forest Act 1993",
                "Structure, rights, and governance of Community Forest User Groups (CFUGs)",
                "Socio-economic contributions of CFUGs to rural schools, health, and roads",
                "Second-generation issues: Elite capture, timber commercialization, and intergovernmental tax disputes",
                "Climate change vulnerability and community-based adaptation (LAPA & NAPA)"
            ),
            materialIds = listOf("rd_mat_03"),
            primaryQuestionId = "tu_q_rd_04",
            tuExamTip = "Highlight that CFUGs act as schools of grassroots democracy with mandatory 50% women representation in executive committees."
        ),
        DayPlan(
            dayNumber = 5,
            subject = Subject.RURAL_DEVELOPMENT,
            title = "Day 5: Federalism, Local Governance & LGOA 2074",
            subtitle = "Schedule 8 Exclusive Powers, 7-Step Planning & Judicial Committees",
            targetMinutes = 60,
            unitName = "RD Unit 5: Decentralization & Palika Governance",
            overview = "Master local autonomy under the 2015 Constitution, Local Government Operation Act 2074, and the 7-step bottom-up planning cycle.",
            coreTopics = listOf(
                "Constitutional division of power: Schedule 8 (Local) vs Schedule 9 (Concurrent)",
                "Local Government Operation Act 2074 key institutional provisions",
                "7-Step bottom-up participatory planning process from Tole to Municipal Assembly",
                "Role and challenges of Judicial Committees (*Nyayik Samiti*) chaired by Deputy Mayors",
                "Fiscal Federalism: Internal revenue generation vs central equalization grants"
            ),
            materialIds = listOf("rd_mat_04"),
            primaryQuestionId = "tu_q_rd_05",
            tuExamTip = "Be ready to list all 7 steps of the local planning cycle sequentially in order—this is a frequent TU exam question!"
        ),
        DayPlan(
            dayNumber = 6,
            subject = Subject.RURAL_DEVELOPMENT,
            title = "Day 6: Project Planning & Participatory Tools (PRA & RRA)",
            subtitle = "Project Cycle Management, Logical Framework (LogFrame) & PRA Tools",
            targetMinutes = 60,
            unitName = "RD Unit 6: Development Project Cycle & Tools",
            overview = "Learn project cycle stages, Logical Framework Matrix (LogFrame), and practical tools for rural participatory appraisal.",
            coreTopics = listOf(
                "Project Cycle Management: Identification, Formulation, Appraisal, Implementation, Monitoring & Evaluation",
                "Logical Framework Matrix (LogFrame): Goal, Purpose, Outputs, Activities, OVIs, and Assumptions",
                "Participatory Rural Appraisal (PRA) vs Rapid Rural Appraisal (RRA)",
                "Key PRA Tools: Transect Walk, Resource & Social Mapping, Seasonal Calendar, Venn Diagram, Pairwise Ranking",
                "Difference between Monitoring and Evaluation"
            ),
            materialIds = listOf("soc_mat_04"),
            primaryQuestionId = "tu_q_rd_06",
            tuExamTip = "Draw a sample 4x4 LogFrame table in your exam paper to demonstrate practical mastery."
        ),
        DayPlan(
            dayNumber = 7,
            subject = Subject.RURAL_DEVELOPMENT,
            title = "Day 7: Gender & Social Inclusion (GESI) in Rural Development",
            subtitle = "GESI Mainstreaming, Dalit Inclusion & Indigenous Knowledge",
            targetMinutes = 60,
            unitName = "RD Unit 7: Inclusive Development Strategies",
            overview = "Examine GESI frameworks, targeted budgeting, affirmative action in local bodies, and mainstreaming marginalized voices.",
            coreTopics = listOf(
                "Concept of Gender Mainstreaming vs WID vs GAD",
                "Gender Responsive Budgeting (GRB) in local government budgets",
                "Social Inclusion of Dalits, Janajatis, Madhesis, Muslims, and PwDs",
                "Affirmative action provisions in the Constitution of Nepal 2072",
                "Role of indigenous and local knowledge in sustainable rural practices"
            ),
            materialIds = listOf("rd_mat_01", "rd_mat_04"),
            primaryQuestionId = "tu_q_rd_07",
            tuExamTip = "Cite the Gender Inequality Index (GII) trends and local government gender quotas in your introductory remarks."
        ),
        DayPlan(
            dayNumber = 8,
            subject = Subject.RURAL_DEVELOPMENT,
            title = "Day 8: Rural Development Comprehensive Review & Board Model Exam",
            subtitle = "15th/16th Periodic Plan Targets, Full RD Model Paper Solving",
            targetMinutes = 60,
            unitName = "RD Unit 8: TU Board Exam Synthesis",
            overview = "Synthesize all Rural Development units, review national periodic plan targets, and attempt full-length TU board questions.",
            coreTopics = listOf(
                "Overview of 15th Plan and 16th Periodic Plan (2081/82 - 2085/86) rural targets",
                "Graduation from LDC status by 2026 and implications for rural development",
                "Group A (10 MCQs), Group B (Short Questions), Group C (Analytical Questions) format",
                "Time management strategy: 3 hours for 100 marks (1.8 minutes per mark)",
                "Full RD Revision Checklist"
            ),
            materialIds = listOf("rd_mat_01", "rd_mat_02", "rd_mat_03", "rd_mat_04"),
            primaryQuestionId = "tu_q_rd_08",
            tuExamTip = "For 15-mark questions, spend 25 minutes, write 4–5 pages with clear sub-headings, flowchart diagrams, and policy critiques."
        ),
        DayPlan(
            dayNumber = 9,
            subject = Subject.SOCIOLOGY,
            title = "Day 9: Classical Sociological Theorists (Comte, Marx, Durkheim, Weber)",
            subtitle = "Positivism, Historical Materialism, Social Facts & Interpretive Action",
            targetMinutes = 60,
            unitName = "SOC Unit 1: Classical Sociological Theory",
            overview = "Master the founding thinkers of sociology: Auguste Comte, Karl Marx, Émile Durkheim, and Max Weber.",
            coreTopics = listOf(
                "Emergence of Sociology in 19th Century Europe",
                "Auguste Comte: Law of Three Stages and Positivism",
                "Karl Marx: Historical Materialism, Base-Superstructure, Class Struggle, and Alienation",
                "Émile Durkheim: Social Facts, Mechanical vs Organic Solidarity, and Study of Suicide",
                "Max Weber: Social Action, Verstehen, Protestant Ethic, Bureaucracy"
            ),
            materialIds = listOf("soc_mat_01"),
            primaryQuestionId = "tu_q_soc_01",
            tuExamTip = "Compare Marx and Weber on social stratification (Marx = single economic axis; Weber = Class, Status, Party multidimensional)."
        ),
        DayPlan(
            dayNumber = 10,
            subject = Subject.SOCIOLOGY,
            title = "Day 10: Nepalese Social Structure & Muluki Ain 1854",
            subtitle = "Caste System Codification, Tagadhari-Matawali Hierarchy & Sanskritization",
            targetMinutes = 60,
            unitName = "SOC Unit 2: Social Structure of Nepal",
            overview = "Analyze the historical emergence of caste hierarchy in Nepal through the 1854 Muluki Ain and the concept of Sanskritization.",
            coreTopics = listOf(
                "Historical roots of caste stratification in Nepal",
                "Muluki Ain 1854: 4-tier hierarchy (Tagadhari, Namasinyaka Matawali, Masinyaka Matawali, Untouchables)",
                "M.N. Srinivas's concept of Sanskritization and its application in Nepal",
                "Jajmani/Bali-Ghar system and traditional occupational dependencies",
                "Transition from ritual purity-pollution to legal equality in modern Nepal"
            ),
            materialIds = listOf("soc_mat_02"),
            primaryQuestionId = "tu_q_soc_02",
            tuExamTip = "Mention that unlike India's rigid 4-varna model, Nepal's 1854 Muluki Ain incorporated diverse ethnic Janajatis as 'Matawali'."
        ),
        DayPlan(
            dayNumber = 11,
            subject = Subject.SOCIOLOGY,
            title = "Day 11: Dor Bahadur Bista's Fatalism & Social Stratification",
            subtitle = "Fatalism and Development, Afno Manchhe, Chakari & Hierarchy in Nepal",
            targetMinutes = 60,
            unitName = "SOC Unit 3: Cultural Critique & Stratification",
            overview = "Examine Dor Bahadur Bista's seminal thesis in 'Fatalism and Development' and modern sociological debates on Nepalese inequality.",
            coreTopics = listOf(
                "Dor Bahadur Bista's thesis in 'Fatalism and Development' (1991)",
                "Concepts of Fatalism (*Bhagyabad*), *Afno Manchhe*, and *Chakari*",
                "Devaluation of manual labor and preference for bureaucratic/clerical status",
                "Critiques of Bista: Did he over-generalize Brahmanical culture?",
                "Class, Caste, and Gender intersectionality in contemporary Nepal"
            ),
            materialIds = listOf("soc_mat_02"),
            primaryQuestionId = "tu_q_soc_03",
            tuExamTip = "Provide a balanced critical answer: acknowledge Bista's powerful insights while presenting modern sociological counter-arguments."
        ),
        DayPlan(
            dayNumber = 12,
            subject = Subject.SOCIOLOGY,
            title = "Day 12: Social Movements, Ethnicity & Transformation in Nepal",
            subtitle = "Janajati, Dalit, Madhesh Movements & Identity Politics",
            targetMinutes = 60,
            unitName = "SOC Unit 4: Social Movements & State Restructuring",
            overview = "Explore post-1990 social movements in Nepal: Adivasi Janajati assertion, Dalit human rights, Madhesh movement, and secularization.",
            coreTopics = listOf(
                "Theoretical concepts of Social Movements",
                "Post-1990 Adivasi Janajati movement and NEFIN's demands",
                "Madhesh Movement and demands for proportional representation",
                "Dalit Movement against untouchability and discrimination (*Jatiya Bhedbhav*)",
                "State restructuring: Monarchy to Secular Federal Democratic Republic"
            ),
            materialIds = listOf("soc_mat_02", "soc_mat_03"),
            primaryQuestionId = "tu_q_soc_04",
            tuExamTip = "Link social movements to concrete constitutional outcomes: secularism, federalism, proportional electoral quotas (Article 84)."
        ),
        DayPlan(
            dayNumber = 13,
            subject = Subject.SOCIOLOGY,
            title = "Day 13: Research Methodology in Social Sciences",
            subtitle = "Qualitative vs Quantitative, Sampling, Fieldwork Tools & Triangulation",
            targetMinutes = 60,
            unitName = "SOC Unit 5: Social Research Methods",
            overview = "Master research design, sampling methods, qualitative immersion tools, and ethical considerations in social research.",
            coreTopics = listOf(
                "Positivist (Quantitative) vs Interpretivist (Qualitative) research paradigms",
                "Probability sampling vs Non-probability sampling",
                "Primary data tools: Structured Questionnaires, KIIs, FGDs, Participant Observation",
                "Concept of Triangulation and mixed-methods research design",
                "Research Ethics: Informed consent, confidentiality, and cultural sensitivity"
            ),
            materialIds = listOf("soc_mat_04"),
            primaryQuestionId = "tu_q_soc_05",
            tuExamTip = "Prepare a sample questionnaire or interview checklist—TU examiners often ask students to design a 5-question tool for a topic."
        ),
        DayPlan(
            dayNumber = 14,
            subject = Subject.SOCIOLOGY,
            title = "Day 14: Family, Marriage, Kinship & Gender in Nepal",
            subtitle = "Patrilineality, Polyandry, Inter-Caste Marriage & Changing Gender Roles",
            targetMinutes = 60,
            unitName = "SOC Unit 6: Basic Social Institutions",
            overview = "Examine traditional kinship systems, diverse marriage forms, and modern family shifts.",
            coreTopics = listOf(
                "Forms of marriage in Nepal: Monogamy, Fraternal Polyandry, Elopement, Arranged Marriage",
                "Kinship rules: Patrilineal vs Matrilineal practices, Guthi and clan (*Kul*) rituals",
                "Rise of nuclear families and decline of joint households",
                "Changing gender roles: Women's inheritance rights under Civil Code 2074",
                "Legalization and social attitudes toward inter-caste and inter-religious marriages"
            ),
            materialIds = listOf("soc_mat_02", "soc_mat_03"),
            primaryQuestionId = "tu_q_soc_06",
            tuExamTip = "Mention specific ethnographic examples like fraternal polyandry among Nyinba of Humla and cross-cousin marriage among Gurungs."
        ),
        DayPlan(
            dayNumber = 15,
            subject = Subject.SOCIOLOGY,
            title = "Day 15: Globalization, Migration & Remittance Impact",
            subtitle = "Transnationalism, Remittance Economy, De-facto Female Headship & Social Cost",
            targetMinutes = 60,
            unitName = "SOC Unit 7: Globalization & Social Change",
            overview = "Investigate the sociology of transnational labor migration, remittance dependency, changing rural demography, and cultural globalization in Nepal.",
            coreTopics = listOf(
                "Sociological drivers of foreign labor migration",
                "Economic vs Social Remittances (ideas, values, gender norms)",
                "De-facto female headship and reconfiguration of rural household authority",
                "The 'Left-Behind' population: Challenges faced by rural elderly and children",
                "Cultural globalization, consumerism, and youth identity in Nepal"
            ),
            materialIds = listOf("soc_mat_03"),
            primaryQuestionId = "tu_q_soc_07",
            tuExamTip = "Differentiate clearly between economic remittances (money) and social remittances (skills, political consciousness, egalitarian values)."
        ),
        DayPlan(
            dayNumber = 16,
            subject = Subject.SOCIOLOGY,
            title = "Day 16: Sociology Final Review & TU Model Question Practice",
            subtitle = "Comprehensive Theoretical Synthesis & Full Mock Examination",
            targetMinutes = 60,
            unitName = "SOC Unit 8: TU Final Examination Synthesis",
            overview = "Review all core sociological theories, Nepalese social dynamics, and attempt a comprehensive TU BA final examination simulation.",
            coreTopics = listOf(
                "Comprehensive theory mapping: Marx, Durkheim, Weber, Comte, Bista, Srinivas",
                "Key concepts quick recap: Social Facts, Alienation, Verstehen, Sanskritization, Fatalism, Triangulation",
                "Group A (10 Objective MCQs) speed drill",
                "Group B (Short Answers) structure: 2-3 pages, 15 minutes each",
                "Group C (Long Analytical Answers) structure: Introduction, Theory, Nepal evidence, Critique, Way forward"
            ),
            materialIds = listOf("soc_mat_01", "soc_mat_02", "soc_mat_03", "soc_mat_04"),
            primaryQuestionId = "tu_q_soc_08",
            tuExamTip = "Maintain clean handwriting, use clear headings, underline key thinkers' names, and ensure balanced time allocation across all sections."
        )
    )

    val tuQuestions: List<TUQuestion> = listOf(
        TUQuestion(
            id = "tu_q_rd_01",
            subject = Subject.RURAL_DEVELOPMENT,
            courseCode = "RD-421",
            questionType = QuestionType.LONG_ANSWER,
            tuYearAsked = "TU Board 2080 / Model 2081",
            questionText = "Critically analyze Amartya Sen's Capability Approach. How is this approach relevant in addressing rural poverty and underdevelopment in Nepal?",
            nepaliQuestionText = "अमर्त्य सेनको सक्षमता अवधारणा (Capability Approach) को आलोचनात्मक विश्लेषण गर्नुहोस्। नेपालको ग्रामीण गरिबी र अल्पविकास समाधानमा यो अवधारणा कसरी सान्दर्भिक छ?",
            marks = 10,
            modelAnswer = """
### Model Answer (TU Group C - 10 Marks Format)

#### 1. Introduction & Conceptual Framework
The Capability Approach, pioneered by Nobel laureate Amartya Sen in works such as *Development as Freedom (1999)*, defines development as the expansion of "real freedoms" (capabilities) that people enjoy to lead lives they have reason to value. Rather than measuring well-being merely by income or commodity possession, it focuses on what individuals are actually able to do and be (*Functionings*).

#### 2. Key Components of Sen's Approach
* **Functionings:** The states of "doing and being" that a person values (e.g., being adequately nourished, healthy, literate, having self-respect, and participating in public life).
* **Capabilities:** The substantive freedom of choice an individual possesses to achieve combinations of functioning.
* **Conversion Factors:** Personal, environmental, and social factors (gender, disability, geography, social norms) that govern how efficiently an individual can convert commodities into capabilities.

#### 3. Relevance to Rural Development in Nepal
1. **Multidimensional Poverty in Mountain & Karnali Regions:** Geographical isolation and lack of roads curtail basic capabilities like healthcare and market participation.
2. **Gender Deprivation & Female Capabilities:** High female participation in farming (*feminization of agriculture*) coexists with deep-rooted practices (*Chhaupadi*, lack of land titles) that restrict women's agency.
3. **Decentralization & Voice (LGOA 2074):** Mandatory representation of Dalit women in Ward Committees provides genuine political agency in the 7-step local planning process.
4. **Education & Skill Development:** Prioritizes functional literacy and livelihood skills needed to break the cycle of subsistence poverty.

#### 4. Conclusion
Amartya Sen's capability approach provides a holistic compass for Nepal's 16th Periodic Plan and LDC graduation strategy.
            """.trimIndent(),
            evaluationRubric = listOf(
                RubricCriterion("c1", "Definition of Capability vs Functioning & Sen's philosophy", 2.5, "Accurate theoretical explanation with clear distinction."),
                RubricCriterion("c2", "Application to Nepalese rural context (Karnali, Gender, LGOA)", 3.5, "Concrete Nepal-specific examples, geographical and social realities."),
                RubricCriterion("c3", "Critical evaluation and limitations", 2.0, "Sound analysis of operational and measurement challenges."),
                RubricCriterion("c4", "Structure, clarity, and academic conclusion", 2.0, "Proper introduction, sub-headings, and forward-looking synthesis.")
            ),
            keyPointsRequired = listOf(
                "Distinction between Functionings (achievements) and Capabilities (freedoms)",
                "Conversion factors (personal, environmental, social)",
                "Nepal application: Karnali multidimensional poverty, gender empowerment, local governance",
                "Critique of pure GDP/income-based poverty metrics"
            )
        ),

        TUQuestion(
            id = "tu_q_rd_05",
            subject = Subject.RURAL_DEVELOPMENT,
            courseCode = "RD-422",
            questionType = QuestionType.LONG_ANSWER,
            tuYearAsked = "TU Board 2079 / 2080 Regular",
            questionText = "Explain the 7-step bottom-up planning process under the Local Government Operation Act 2074. Discuss how it fosters citizen participation.",
            nepaliQuestionText = "स्थानीय सरकार सञ्चालन ऐन २०७४ बमोजिमको सात दिगो योजना तर्जुमा प्रक्रिया व्याख्या गर्नुहोस्। यसले नागरिक सहभागितालाई कसरी प्रवर्द्धन गर्दछ, छलफल गर्नुहोस्।",
            marks = 10,
            modelAnswer = """
### Model Answer (TU Group C - 10 Marks Format)

#### 1. Introduction
The Constitution of Nepal 2072 devolved extensive executive, legislative, and judicial powers to 753 local governments under Schedule 8. The **Local Government Operation Act 2074 (स्थानीय सरकार सञ्चालन ऐन २०७४)** institutionalized a mandatory **7-Step Bottom-Up Planning Process**.

#### 2. The 7 Steps of the Local Planning Cycle
* **Step 1: Resource Estimation & Budget Ceiling Determination (स्रोत अनुमान तथा बजेट सीमा निर्धारण):** By mid-Poush by Resource Estimation Committee.
* **Step 2: Selection of Priorities & Guidelines Formulation (प्राथमिकता निर्धारण तथा मार्गदर्शन):** Executive Board prepares thematic guidelines and ward ceilings.
* **Step 3: Settlement/Tole-Level Need Identification (टोल/बस्ती स्तरमा योजना छनोट):** Citizen public assemblies (*Tole Bhela*) directly propose and prioritize local demands.
* **Step 4: Ward-Level Project Prioritization & Consolidation (वडा स्तरमा योजना प्राथमिकीकरण):** 5-member Ward Committee synthesizes tole requests.
* **Step 5: Budget and Program Formulation Committee Review (बजेट तथा कार्यक्रम तर्जुमा समिति):** Chaired by Deputy Mayor / Vice-Chairperson.
* **Step 6: Executive Board Approval & Finalization (कार्यपालिका बैठकबाट बजेट अनुमोदन):** Municipal Executive passes draft budget.
* **Step 7: Presentation and Endorsement at Assembly (सभामा पेश र पारित):** Presented by **Asar 10** and passed before **Asar 30**.

#### 3. How It Fosters Citizen Participation
1. Direct Deliberation at Tole Level.
2. Mandatory GESI Allocation for women, Dalits, and youth.
3. Social Audits (*Samajik Parikshan*) and Public Hearings.
            """.trimIndent(),
            evaluationRubric = listOf(
                RubricCriterion("c1", "Accurate chronological listing of all 7 steps", 4.0, "All 7 stages correctly titled and described."),
                RubricCriterion("c2", "Legal references (LGOA 2074, dates like Asar 10)", 2.0, "Accurate statutory deadlines and institutional committees."),
                RubricCriterion("c3", "Analysis of citizen participation & GESI", 2.5, "Evaluation of tole assemblies, social audit, and inclusion."),
                RubricCriterion("c4", "Critical hurdles and concluding synthesis", 1.5, "Realistic critique of user committee capture.")
            ),
            keyPointsRequired = listOf(
                "Step 1 to Step 7 in exact chronological order",
                "Statutory dates: Resource ceiling by mid-Poush, Assembly presentation by Asar 10, Approval by Asar 30",
                "Role of Tole Bhela in participatory need identification"
            )
        ),

        TUQuestion(
            id = "tu_q_soc_01",
            subject = Subject.SOCIOLOGY,
            courseCode = "SOC-421",
            questionType = QuestionType.LONG_ANSWER,
            tuYearAsked = "TU Board 2080 / Model 2081",
            questionText = "Compare and contrast Karl Marx's Historical Materialism with Max Weber's Theory of Social Action and Rationalization.",
            nepaliQuestionText = "कार्ल मार्क्सको ऐतिहासिक भौतिकवाद र म्याक्स वेबरको सामाजिक क्रिया तथा औचित्यीकरणको सिद्धान्तबीच तुलना र भिन्नता स्पष्ट गर्नुहोस्।",
            marks = 10,
            modelAnswer = """
### Model Answer (TU Group C - 10 Marks Format)

#### 1. Comparative Analysis: Marx vs Weber
* **Primary Driver of History:** Marx = Economic infrastructure (Forces and Relations of Production). Weber = Interplay of economics, religious ideas, and rationalization.
* **View of Ideas/Religion:** Marx = Superstructure reflecting economic interests. Weber = Autonomous social force (e.g., *Protestant Ethic*).
* **Social Stratification:** Marx = Unidimensional (Bourgeoisie vs Proletariat). Weber = Multidimensional (Class, Status, Party).
* **Modern Society:** Marx = Capitalist exploitation & Alienation (*Entfremdung*). Weber = Rationalization & the "Iron Cage" (*Stahlhartes Gehäuse*).

#### 2. Application to Nepalese Society
* **Marxian Perspective:** Explains historical landlessness of Dalits and bonded labor (*Kamaiya/Haruwa-Charuwa*) as products of feudal property ownership (*Jamindari*).
* **Weberian Perspective:** Explains how status honors (caste ritual purity in 1854 Muluki Ain) operated independently of pure economic wealth.
            """.trimIndent(),
            evaluationRubric = listOf(
                RubricCriterion("c1", "Clarity of theoretical comparison", 3.5, "Thorough comparative analysis across multiple dimensions."),
                RubricCriterion("c2", "Key concepts explained (Alienation, Verstehen, Iron Cage)", 2.5, "Correct use of classical sociological terminology."),
                RubricCriterion("c3", "Application to Nepalese society (Caste vs Class)", 2.0, "Concrete linkage to historical and modern Nepal."),
                RubricCriterion("c4", "Structural presentation and conclusion", 2.0, "Clean academic layout.")
            ),
            keyPointsRequired = listOf(
                "Marx's economic base-superstructure vs Weber's cultural ideas/Protestant ethic",
                "Unidimensional class vs Three-dimensional Class-Status-Party",
                "Worker Alienation vs Weberian Iron Cage & Rationalization"
            )
        ),

        TUQuestion(
            id = "tu_q_soc_02",
            subject = Subject.SOCIOLOGY,
            courseCode = "SOC-422",
            questionType = QuestionType.LONG_ANSWER,
            tuYearAsked = "TU Board 2079 / 2080 Regular",
            questionText = "Critically discuss Dor Bahadur Bista's thesis in 'Fatalism and Development'. How far do you agree that fatalism is the main obstacle to Nepal's development?",
            nepaliQuestionText = "डोरबहादुर विष्टको 'भाग्यवाद र विकास' (Fatalism and Development) कृतिको आलोचनात्मक छलफल गर्नुहोस्। भाग्यवाद नै नेपालको विकासको मुख्य बाधक हो भन्ने भनाइसँग तपाईं कत्तिको सहमत हुनुहुन्छ?",
            marks = 10,
            modelAnswer = """
### Model Answer (TU Group C - 10 Marks Format)

#### 1. Core Themes of Bista's Thesis (1991)
* **Fatalism (*Bhagyabad*):** Belief that destiny is pre-determined by Karma, discouraging proactive planning and accountability.
* **Afno Manchhe Culture:** Decisions in government, promotions, and projects made based on kinship and patronage circles over universal meritocracy.
* **Chakari System:** Institutionalized sycophancy to secure career advancement.
* **Devaluation of Physical Labor:** Prestige attached to clerical posts (*Kalam Chalaune*) while productive artisanal/agricultural labor is degraded.

#### 2. Sociological Counter-Critique
1. **Cultural Essentialism:** Overemphasizes attitudes while neglecting geography, resource constraints, and Rana oligarchic exploitation.
2. **Homogenization:** Assumes all high-caste groups shared identical values.
3. **Resilience & Agency:** Massive entrepreneurial drive displayed by Nepalese migrant workers globally disproves inherent fatalism.
            """.trimIndent(),
            evaluationRubric = listOf(
                RubricCriterion("c1", "Explanation of Bista's core concepts", 3.5, "Accurate presentation of all key themes."),
                RubricCriterion("c2", "Critical evaluation and sociological counter-arguments", 3.0, "Well-argued critiques: cultural essentialism vs material conditions."),
                RubricCriterion("c3", "Nepalese contemporary context and examples", 2.0, "Relevance to current governance, migration, and bureaucracy."),
                RubricCriterion("c4", "Balanced academic conclusion", 1.5, "Strong synthesis.")
            ),
            keyPointsRequired = listOf(
                "Definition of Fatalism (Bhagyabad), Afno Manchhe, Chakari, and labor devaluation",
                "Bista's argument on high-caste values",
                "Sociological critiques: cultural essentialism, neglect of political-economic structures",
                "Modern migrant entrepreneurship counter-evidence"
            )
        ),

        TUQuestion(
            id = "tu_mcq_01",
            subject = Subject.RURAL_DEVELOPMENT,
            courseCode = "RD-421",
            questionType = QuestionType.MCQ,
            tuYearAsked = "TU Model Question 2081",
            questionText = "Which schedule of the Constitution of Nepal (2072) lists the 22 exclusive powers of Local Governments?",
            options = listOf("Schedule 5", "Schedule 7", "Schedule 8", "Schedule 9"),
            correctOptionIndex = 2,
            marks = 1,
            modelAnswer = "Schedule 8 of the Constitution of Nepal outlines the 22 exclusive powers devolved to Local Governments.",
            explanation = "Schedule 5 details Federal powers, Schedule 6 Provincial powers, Schedule 7 Concurrent Federal-Provincial powers, Schedule 8 Exclusive Local powers, and Schedule 9 Concurrent powers of all three tiers."
        ),

        TUQuestion(
            id = "tu_mcq_02",
            subject = Subject.RURAL_DEVELOPMENT,
            courseCode = "RD-422",
            questionType = QuestionType.MCQ,
            tuYearAsked = "TU Board 2080",
            questionText = "According to the Local Government Operation Act 2074, by which date must the annual budget be presented to the Municipal / Village Assembly?",
            options = listOf("Jestha 15", "Asar 10", "Asar 30", "Shrawan 1"),
            correctOptionIndex = 1,
            marks = 1,
            modelAnswer = "Asar 10 is the statutory deadline for presenting the annual municipal budget to the Village/Municipal Assembly.",
            explanation = "Federal budget is presented on Jestha 15, Provincial budget on Asar 1, and Local Government budget on Asar 10 (with final assembly endorsement required by Asar 30)."
        ),

        TUQuestion(
            id = "tu_mcq_03",
            subject = Subject.RURAL_DEVELOPMENT,
            courseCode = "RD-421",
            questionType = QuestionType.MCQ,
            tuYearAsked = "TU Board 2079",
            questionText = "Which of the following is NOT one of the five livelihood assets in DFID's Sustainable Livelihoods Framework?",
            options = listOf("Human Capital", "Natural Capital", "Political Capital", "Social Capital"),
            correctOptionIndex = 2,
            marks = 1,
            modelAnswer = "The 5 core DFID capitals are Human, Natural, Physical, Financial, and Social capital. 'Political Capital' is not part of the standard pentagon.",
            explanation = "While political voice is crucial, DFID's canonical asset pentagon consists of Human, Natural, Physical, Financial, and Social capitals."
        ),

        TUQuestion(
            id = "tu_mcq_04",
            subject = Subject.SOCIOLOGY,
            courseCode = "SOC-421",
            questionType = QuestionType.MCQ,
            tuYearAsked = "TU Model 2081",
            questionText = "Who among the following classical sociological thinkers introduced the concept of 'Social Facts' (Choses Sociales)?",
            options = listOf("Karl Marx", "Émile Durkheim", "Max Weber", "Auguste Comte"),
            correctOptionIndex = 1,
            marks = 1,
            modelAnswer = "Émile Durkheim established 'Social Facts' in his 1895 work 'The Rules of Sociological Method'.",
            explanation = "Durkheim defined social facts as ways of acting, thinking, and feeling external to the individual and endowed with coercive power."
        ),

        TUQuestion(
            id = "tu_mcq_05",
            subject = Subject.SOCIOLOGY,
            courseCode = "SOC-422",
            questionType = QuestionType.MCQ,
            tuYearAsked = "TU Board 2080",
            questionText = "In which year was the historical Muluki Ain (Civil Code) that first legally codified the caste hierarchy in Nepal promulgated?",
            options = listOf("1854 AD (1910 BS)", "1951 AD (2007 BS)", "1964 AD (2021 BS)", "1990 AD (2047 BS)"),
            correctOptionIndex = 0,
            marks = 1,
            modelAnswer = "The first Muluki Ain was promulgated in 1854 AD (1910 BS) by Prime Minister Jung Bahadur Rana.",
            explanation = "The 1854 Muluki Ain codified the multi-ethnic population of Nepal into a unified 4-tier caste-based social hierarchy."
        ),

        TUQuestion(
            id = "tu_mcq_06",
            subject = Subject.SOCIOLOGY,
            courseCode = "SOC-421",
            questionType = QuestionType.MCQ,
            tuYearAsked = "TU Board 2079",
            questionText = "The sociological concept of 'Verstehen' (empathetic understanding of subjective meaning) is most closely associated with which thinker?",
            options = listOf("Émile Durkheim", "Max Weber", "Karl Marx", "Herbert Spencer"),
            correctOptionIndex = 1,
            marks = 1,
            modelAnswer = "Max Weber developed 'Verstehen' as the core methodological cornerstone of Interpretive Sociology.",
            explanation = "Weber argued that unlike natural sciences, sociology must interpret the subjective meanings individuals attach to their social actions."
        ),

        TUQuestion(
            id = "tu_mcq_07",
            subject = Subject.SOCIOLOGY,
            courseCode = "SOC-422",
            questionType = QuestionType.MCQ,
            tuYearAsked = "TU Model 2080",
            questionText = "The sociological concept of 'Sanskritization' was originally formulated by which social scientist?",
            options = listOf("Dor Bahadur Bista", "M.N. Srinivas", "G.S. Ghurye", "Chaitanya Mishra"),
            correctOptionIndex = 1,
            marks = 1,
            modelAnswer = "M.N. Srinivas formulated 'Sanskritization' in his 1952 study of the Coorgs of South India.",
            explanation = "Sanskritization describes the process by which lower castes emulate the customs, rituals, ideology, and way of life of twice-born high castes."
        ),

        TUQuestion(
            id = "tu_mcq_08",
            subject = Subject.RURAL_DEVELOPMENT,
            courseCode = "RES-401",
            questionType = QuestionType.MCQ,
            tuYearAsked = "TU Board 2081",
            questionText = "In social research methodology, what is the term for combining multiple data sources, methods, or theories to validate findings?",
            options = listOf("Stratification", "Triangulation", "Social Mapping", "Operationalization"),
            correctOptionIndex = 1,
            marks = 1,
            modelAnswer = "Triangulation is the cross-verification of research results using multiple methods, data sources, or theoretical perspectives.",
            explanation = "Triangulation enhances research validity by combining qualitative and quantitative data."
        ),

        TUQuestion(
            id = "tu_mcq_eng_01",
            subject = Subject.COMPULSORY_LANGUAGE,
            courseCode = "C.Eng-401",
            questionType = QuestionType.MCQ,
            tuYearAsked = "TU Board 2081",
            questionText = "Which rhetorical transition word best indicates a contrast between two academic arguments?",
            options = listOf("Furthermore", "Conversely", "Consequently", "Moreover"),
            correctOptionIndex = 1,
            marks = 1,
            modelAnswer = "'Conversely' is used to introduce an idea, argument, or situation that is the opposite of the one just stated.",
            explanation = "In academic writing, 'conversely' signals a direct contrast or antithetical viewpoint, whereas 'furthermore' and 'moreover' signal addition, and 'consequently' signals a result."
        )
    )

    val tu4YearCurriculumList: List<com.example.data.model.TUYearSyllabus> = listOf(
        // ======================== BA 1ST YEAR (5 SUBJECTS) ========================
        com.example.data.model.TUYearSyllabus(
            yearNumber = 1,
            yearLabel = "BA 1st Year (5 Subjects • 500 Full Marks)",
            subtitle = "Foundations of Rural Development, Classical Sociology & Academic English",
            description = "In BA 1st Year under TU FOHSS, students take exactly 5 papers (500 Marks): 2 Rural Development Major papers, 2 Sociology Major papers, and 1 Compulsory English paper.",
            papers = listOf(
                com.example.data.model.TUCoursePaper(
                    courseCode = "C.Eng. 401",
                    title = "Compulsory English I: Reading & Academic Writing",
                    nepaliTitle = "अनिवार्य अंग्रेजी प्रथम",
                    category = com.example.data.model.CourseCategory.COMPULSORY,
                    paperNumber = "Compulsory Paper",
                    major = Subject.COMPULSORY_LANGUAGE,
                    description = "Focuses on comprehension of academic essays, critical analysis of social texts, sentence structures, vocabulary development, and formal academic paragraph and essay writing.",
                    units = listOf(
                        "Unit 1: Critical Reading & Textual Analysis (Literary & Non-Literary Prose)",
                        "Unit 2: Academic Vocabulary & Contextual Morphology",
                        "Unit 3: Structural Sentence Composition & Grammar for Academic Discourse",
                        "Unit 4: Rhetorical Modes (Expository, Argumentative, Descriptive Essays)",
                        "Unit 5: Summary Writing, Paraphrasing & Preliminary APA Citation"
                    ),
                    keyThinkersOrActs = listOf("Critical Essay Writing", "Academic Discourse", "Textual Analysis", "APA Basics")
                ),
                com.example.data.model.TUCoursePaper(
                    courseCode = "RD 421",
                    title = "Theories & Concepts of Rural Development",
                    nepaliTitle = "ग्रामीण विकासका सिद्धान्त र अवधारणाहरू (Paper I)",
                    category = com.example.data.model.CourseCategory.RURAL_DEVELOPMENT_MAJOR,
                    paperNumber = "RD Major Paper I",
                    major = Subject.RURAL_DEVELOPMENT,
                    description = "Examines fundamental development paradigms, modernization growth stages, dependency core-periphery models, basic human needs, and Amartya Sen's Capability Approach.",
                    units = listOf(
                        "Unit 1: Meaning, Dimensions and Objectives of Rural Development in Nepal",
                        "Unit 2: Classical & Modern Development Theories (Rostow, Frank, Amin, Sen)",
                        "Unit 3: DFID Sustainable Rural Livelihoods Framework (5 Asset Capitals)",
                        "Unit 4: Poverty Concepts (Absolute, Relative, Multidimensional Poverty Index - MPI)",
                        "Unit 5: Indigenous Knowledge, Social Capital & Community Mobilization"
                    ),
                    keyThinkersOrActs = listOf("Amartya Sen", "W.W. Rostow", "Andre Gunder Frank", "Robert Chambers", "DFID 5 Capitals")
                ),
                com.example.data.model.TUCoursePaper(
                    courseCode = "RD 422",
                    title = "Rural Economy of Nepal",
                    nepaliTitle = "नेपालको ग्रामीण अर्थतन्त्र (Paper II)",
                    category = com.example.data.model.CourseCategory.RURAL_DEVELOPMENT_MAJOR,
                    paperNumber = "RD Major Paper II",
                    major = Subject.RURAL_DEVELOPMENT,
                    description = "In-depth study of Nepal's agrarian economic structure, historical land tenure systems (Raikar, Birta, Jagir, Kipat), agricultural commercialization, and rural poverty dynamics.",
                    units = listOf(
                        "Unit 1: Structure of Nepalese Rural Economy & Sectoral Contribution to GDP",
                        "Unit 2: Historical Land Tenure Systems & Land Reform Act 2021 BS",
                        "Unit 3: Agricultural Farming Systems, Land Fragmentation & Feminization of Agriculture",
                        "Unit 4: Rural Credit, Informal Finance (Dhukuti, Parma) & Cooperative Sector",
                        "Unit 5: Agricultural Modernization, Value Chains & Land Use Act 2076"
                    ),
                    keyThinkersOrActs = listOf("Land Reform Act 2021", "Land Use Act 2076", "Feminization of Farming", "Mohaiani Haq", "15th/16th Periodic Plan")
                ),
                com.example.data.model.TUCoursePaper(
                    courseCode = "SOC 421",
                    title = "Introduction to Sociology & Sociological Thinkers",
                    nepaliTitle = "समाजशास्त्र परिचय र समाजशास्त्रीय विचारकहरू (Paper I)",
                    category = com.example.data.model.CourseCategory.SOCIOLOGY_MAJOR,
                    paperNumber = "Sociology Major Paper I",
                    major = Subject.SOCIOLOGY,
                    description = "Foundational introduction to the origin of sociology, basic sociological concepts (society, culture, social group, institution), and founding classical theorists.",
                    units = listOf(
                        "Unit 1: Nature, Scope, Subject Matter and Evolution of Sociology",
                        "Unit 2: Basic Sociological Concepts: Society, Culture, Community, Institution, Role & Status",
                        "Unit 3: Auguste Comte (Law of Three Stages & Positivism)",
                        "Unit 4: Karl Marx (Historical Materialism, Class Struggle & Alienation)",
                        "Unit 5: Émile Durkheim (Social Facts & Suicide) & Max Weber (Verstehen & Bureaucracy)"
                    ),
                    keyThinkersOrActs = listOf("Auguste Comte", "Karl Marx", "Émile Durkheim", "Max Weber", "Social Facts", "Verstehen")
                ),
                com.example.data.model.TUCoursePaper(
                    courseCode = "SOC 422",
                    title = "Nepalese Society and Social Structure",
                    nepaliTitle = "नेपाली समाज र सामाजिक संरचना (Paper II)",
                    category = com.example.data.model.CourseCategory.SOCIOLOGY_MAJOR,
                    paperNumber = "Sociology Major Paper II",
                    major = Subject.SOCIOLOGY,
                    description = "Analyzes the historical formation of Nepalese society, caste stratification under the 1854 Muluki Ain, ethnic diversity, and Dor Bahadur Bista's fatalism thesis.",
                    units = listOf(
                        "Unit 1: Historical Evolution of Nepalese Society & Ecological Zones (Mountain, Hill, Terai)",
                        "Unit 2: Caste System in Nepal: Codification under 1854 Muluki Ain (Tagadhari, Matawali, Dalit)",
                        "Unit 3: Dor Bahadur Bista's 'Fatalism and Development' (Afno Manchhe, Chakari & Hierarchy)",
                        "Unit 4: Sanskritization vs Ethnic Assertion & Secularization in Modern Nepal",
                        "Unit 5: Constitutional Provisions against Discrimination (Article 24) & Caste Abolition Act 2068"
                    ),
                    keyThinkersOrActs = listOf("Muluki Ain 1854", "Dor Bahadur Bista", "M.N. Srinivas", "Tagadhari & Matawali", "Caste Discrimination Act 2068")
                )
            ),
            keyObjectives = listOf(
                "Master classical development theories and capability approach (RD 421)",
                "Understand Nepal's agrarian land systems and rural economy (RD 422)",
                "Build foundation in classical thinkers: Marx, Durkheim, Weber, Comte (SOC 421)",
                "Analyze 1854 Muluki Ain caste codification and Bista's fatalism critique (SOC 422)",
                "Develop academic reading comprehension and formal writing skills (C.Eng 401)"
            )
        ),

        // ======================== BA 2ND YEAR (5 SUBJECTS) ========================
        com.example.data.model.TUYearSyllabus(
            yearNumber = 2,
            yearLabel = "BA 2nd Year (5 Subjects • 500 Full Marks)",
            subtitle = "Rural Governance, Environment, Social Stratification & Compulsory Nepali",
            description = "In BA 2nd Year, students study 5 papers (500 Marks): 2 Rural Development papers (Governance & Environment), 2 Sociology papers (Stratification & Social Movements), and Compulsory Nepali.",
            papers = listOf(
                com.example.data.model.TUCoursePaper(
                    courseCode = "C.Nep. 402",
                    title = "Compulsory Nepali (अनिवार्य नेपाली)",
                    nepaliTitle = "अनिवार्य नेपाली",
                    category = com.example.data.model.CourseCategory.COMPULSORY,
                    paperNumber = "Compulsory Paper",
                    major = Subject.COMPULSORY_LANGUAGE,
                    description = "नेपाली भाषाको व्याकरण, प्रयोजनपरक नेपाली, समसामयिक निबन्ध लेखन, प्रतिवेदन लेखन र साहित्यका विविध विधाको अध्ययन।",
                    units = listOf(
                        "एकाइ १: नेपाली वर्ण विन्यास, पदवर्ग र वाक्य संरचना",
                        "एकाइ २: प्रयोजनपरक नेपाली (प्रशासनिक, कानुनी तथा व्यावहारिक लेखन)",
                        "एकाइ ३: समसामयिक सामाजिक तथा विकास निबन्ध लेखन",
                        "एकाइ ४: नेपाली गद्य तथा पद्य साहित्यको अध्ययन र समीक्षा",
                        "एकाइ ५: प्रतिवेदन तथा संक्षेपीकरण लेखन"
                    ),
                    keyThinkersOrActs = listOf("नेपाली व्याकरण", "प्रशासनिक लेखन", "प्रतिवेदन लेखन")
                ),
                com.example.data.model.TUCoursePaper(
                    courseCode = "RD 423",
                    title = "Rural Governance, Decentralization & Local Institutions in Nepal",
                    nepaliTitle = "नेपालमा ग्रामीण सुशासन, विकेन्द्रीकरण र स्थानीय संस्था (Paper III)",
                    category = com.example.data.model.CourseCategory.RURAL_DEVELOPMENT_MAJOR,
                    paperNumber = "RD Major Paper III",
                    major = Subject.RURAL_DEVELOPMENT,
                    description = "Federalism in Nepal, Schedule 8 local powers, Local Government Operation Act 2074 (LGOA), 7-step bottom-up planning cycle, and Judicial Committees (*Nyayik Samiti*).",
                    units = listOf(
                        "Unit 1: Concepts of Good Governance, Decentralization & Subsidiarity Principle",
                        "Unit 2: Constitutional Federal Framework (753 Local Governments & Schedule 8 Powers)",
                        "Unit 3: Local Government Operation Act 2074 (Institutional Architecture)",
                        "Unit 4: The 7-Step Bottom-Up Participatory Planning & Budgeting Process",
                        "Unit 5: Dispute Resolution at Grassroots: Judicial Committee (Nyayik Samiti)"
                    ),
                    keyThinkersOrActs = listOf("LGOA 2074", "Schedule 8 Powers", "7-Step Planning", "Nyayik Samiti", "Fiscal Equalization")
                ),
                com.example.data.model.TUCoursePaper(
                    courseCode = "RD 424",
                    title = "Natural Resource Management, Environment & Rural Tourism",
                    nepaliTitle = "प्राकृतिक स्रोत व्यवस्थापन, वातावरण र ग्रामीण पर्यटन (Paper IV)",
                    category = com.example.data.model.CourseCategory.RURAL_DEVELOPMENT_MAJOR,
                    paperNumber = "RD Major Paper IV",
                    major = Subject.RURAL_DEVELOPMENT,
                    description = "Community forestry under Forest Act 1993, CFUG governance, watershed management, renewable energy, climate change adaptation (LAPA), and Homestay rural tourism.",
                    units = listOf(
                        "Unit 1: Natural Resource Classification, Common Property Resources & Tragedy of Commons",
                        "Unit 2: Community Forestry in Nepal: Evolution, Forest Act 1993 & CFUG Rights",
                        "Unit 3: Water Resource Governance, Irrigation User Associations & Watershed Management",
                        "Unit 4: Climate Change Vulnerability, Disaster Risk Reduction & Community Adaptation (LAPA)",
                        "Unit 5: Community-Based Rural Tourism, Eco-Tourism & Homestay Enterprises"
                    ),
                    keyThinkersOrActs = listOf("Forest Act 1993", "CFUG Governance", "Homestay Guidelines 2067", "LAPA / NAPA", "Elite Capture")
                ),
                com.example.data.model.TUCoursePaper(
                    courseCode = "SOC 423",
                    title = "Social Stratification, Caste, Class & Gender in Nepal",
                    nepaliTitle = "सामाजिक स्तरीकरण, जात, वर्ग र लैंगिकता (Paper III)",
                    category = com.example.data.model.CourseCategory.SOCIOLOGY_MAJOR,
                    paperNumber = "Sociology Major Paper III",
                    major = Subject.SOCIOLOGY,
                    description = "Theories of social stratification (Marxist, Weberian, Functionalist), caste-class dynamics, gender inequality, and Dalit marginalization in Nepal.",
                    units = listOf(
                        "Unit 1: Theories of Social Stratification: Functionalist (Davis-Moore) vs Conflict (Marx, Weber)",
                        "Unit 2: Caste vs Class Intersectionality in Nepalese Agrarian Setting",
                        "Unit 3: Gender Stratification, Patriarchy & Women's Property Rights in Nepal",
                        "Unit 4: Dalit Marginalization, Untouchability & Resistance in Hills and Terai",
                        "Unit 5: Affirmative Action, Quotas & Social Justice under 2072 Constitution"
                    ),
                    keyThinkersOrActs = listOf("Davis & Moore", "Karl Marx", "Max Weber", "Patriarchy in Nepal", "Article 84 Quotas")
                ),
                com.example.data.model.TUCoursePaper(
                    courseCode = "SOC 424",
                    title = "Social Movements, Ethnicity & Diversity in Nepal",
                    nepaliTitle = "सामाजिक आन्दोलन, जातीयता र विविधता (Paper IV)",
                    category = com.example.data.model.CourseCategory.SOCIOLOGY_MAJOR,
                    paperNumber = "Sociology Major Paper IV",
                    major = Subject.SOCIOLOGY,
                    description = "Theories of social movements, Adivasi Janajati movements, Madhesh identity movement, Dalit mobilization, and state restructuring to secular federalism.",
                    units = listOf(
                        "Unit 1: Concepts and Theories of Social Movements (Relative Deprivation, Resource Mobilization)",
                        "Unit 2: The Adivasi Janajati Movement in Post-1990 Nepal & NEFIN's Agenda",
                        "Unit 3: The Madhesh Movement: Demands for Autonomy, Equality & Citizenship Rights",
                        "Unit 4: Dalit Rights Movement and Human Rights Struggles in Nepal",
                        "Unit 5: State Restructuring: Monarchy to Secular Federal Democratic Republic"
                    ),
                    keyThinkersOrActs = listOf("Relative Deprivation", "Adivasi Janajati Agenda", "Madhesh Movement", "Secular Federal Republic")
                )
            ),
            keyObjectives = listOf(
                "Master Local Government Operation Act 2074 and 7-Step Planning (RD 423)",
                "Evaluate Community Forestry and Homestay Rural Tourism (RD 424)",
                "Analyze Theories of Social Stratification: Marx, Weber & Davis-Moore (SOC 423)",
                "Examine Janajati, Dalit & Madhesh Social Movements in Nepal (SOC 424)",
                "Enhance Nepali administrative and essay writing competence (C.Nep 402)"
            )
        ),

        // ======================== BA 3RD YEAR (5 SUBJECTS) ========================
        com.example.data.model.TUYearSyllabus(
            yearNumber = 3,
            yearLabel = "BA 3rd Year (5 Subjects • 500 Full Marks)",
            subtitle = "Project Planning, Microfinance, Research Methodology & Nepal Studies",
            description = "In BA 3rd Year, students take 5 papers (500 Marks): 2 Rural Development papers (Project Cycle & Microfinance), 2 Sociology papers (Research Methods & Kinship/Demography), and Compulsory Nepal Studies.",
            papers = listOf(
                com.example.data.model.TUCoursePaper(
                    courseCode = "C.NepSt. 403",
                    title = "Compulsory Nepal Studies (नेपाल अध्ययन)",
                    nepaliTitle = "नेपाल अध्ययन",
                    category = com.example.data.model.CourseCategory.COMPULSORY,
                    paperNumber = "Compulsory Paper",
                    major = Subject.COMPULSORY_LANGUAGE,
                    description = "Comprehensive study of Nepal's political history, cultural heritage, geography, biodiversity, diplomatic relations, and socio-economic transformation.",
                    units = listOf(
                        "Unit 1: Geographical Features, Natural Diversity & Geo-Strategic Location of Nepal",
                        "Unit 2: Political History of Nepal: Unification to Federal Democratic Republic",
                        "Unit 3: Cultural, Linguistic & Religious Pluralism in Nepal",
                        "Unit 4: Nepalese Economy: Natural Resources, Hydropower, Agriculture & Remittances",
                        "Unit 5: Foreign Policy of Nepal: Non-Alignment, Panchasheel & Bilateral Relations"
                    ),
                    keyThinkersOrActs = listOf("Nepal Geopolitics", "Panchasheel Principles", "Cultural Pluralism", "Federal Constitution 2072")
                ),
                com.example.data.model.TUCoursePaper(
                    courseCode = "RD 425",
                    title = "Rural Development Planning, Project Cycle Management & PRA Tools",
                    nepaliTitle = "ग्रामीण विकास योजना, आयोजना व्यवस्थापन र सहभागितामूलक विधि (Paper V)",
                    category = com.example.data.model.CourseCategory.RURAL_DEVELOPMENT_MAJOR,
                    paperNumber = "RD Major Paper V",
                    major = Subject.RURAL_DEVELOPMENT,
                    description = "Project Cycle Management (PCM), Logical Framework Approach (LogFrame), monitoring indicators (OVIs), PRA vs RRA tools, and impact evaluation.",
                    units = listOf(
                        "Unit 1: Concepts of Development Planning: Top-Down vs Bottom-Up Participatory Planning",
                        "Unit 2: Project Cycle Management (PCM): Identification, Formulation, Appraisal, Implementation, M&E",
                        "Unit 3: Logical Framework Matrix (LogFrame): Goal, Purpose, Outputs, Activities, OVIs & Assumptions",
                        "Unit 4: Participatory Rural Appraisal (PRA) vs Rapid Rural Appraisal (RRA)",
                        "Unit 5: PRA Field Tools: Transect Walk, Resource Map, Venn Diagram, Seasonal Calendar"
                    ),
                    keyThinkersOrActs = listOf("Logical Framework Matrix", "Robert Chambers PRA", "Project Cycle", "Objectively Verifiable Indicators (OVIs)")
                ),
                com.example.data.model.TUCoursePaper(
                    courseCode = "RD 426",
                    title = "Microfinance, Cooperatives & Rural Livelihoods in Nepal",
                    nepaliTitle = "लघुवित्त, सहकारी र ग्रामीण जीविकोपार्जन (Paper VI)",
                    category = com.example.data.model.CourseCategory.RURAL_DEVELOPMENT_MAJOR,
                    paperNumber = "RD Major Paper VI",
                    major = Subject.RURAL_DEVELOPMENT,
                    description = "Three-pillar economy, Cooperative Act 2074, Grameen micro-lending models, women's empowerment, over-indebtedness challenges, and NRB regulations.",
                    units = listOf(
                        "Unit 1: Rural Financial Markets: Formal, Semi-Formal & Informal Financial Institutions",
                        "Unit 2: The Cooperative Movement in Nepal: Principles, Types & Cooperative Act 2074",
                        "Unit 3: Microfinance Institutions (MFIs): Group-Lending Models, Grameen Replication in Nepal",
                        "Unit 4: Women's Empowerment, Micro-Enterprise Development & Poverty Alleviation",
                        "Unit 5: Challenges in Microfinance: Multiple Borrowing, Over-Indebtedness & Regulatory Reforms"
                    ),
                    keyThinkersOrActs = listOf("Cooperative Act 2074", "Grameen Banking Model", "NRB Microfinance Guidelines", "Aama Samuha")
                ),
                com.example.data.model.TUCoursePaper(
                    courseCode = "SOC 425",
                    title = "Social Science Research Methodology & Field Techniques",
                    nepaliTitle = "सामाजिक विज्ञान अनुसन्धान विधि र स्थलगत कार्य (Paper V)",
                    category = com.example.data.model.CourseCategory.SOCIOLOGY_MAJOR,
                    paperNumber = "Sociology Major Paper V",
                    major = Subject.SOCIOLOGY,
                    description = "Research design, quantitative vs qualitative paradigms, sampling strategies (probability & non-probability), questionnaire design, KII, FGD, and Triangulation.",
                    units = listOf(
                        "Unit 1: Foundations of Social Research: Positivist vs Interpretivist Paradigms",
                        "Unit 2: Research Design: Exploratory, Descriptive, Explanatory & Experimental Designs",
                        "Unit 3: Sampling Techniques: Random, Stratified, Cluster, Purposive & Snowball Sampling",
                        "Unit 4: Primary Data Tools: Structured Questionnaires, KII, Focus Group Discussions (FGD)",
                        "Unit 5: Data Processing, Triangulation, Ethical Standards & APA 7th Referencing"
                    ),
                    keyThinkersOrActs = listOf("Triangulation", "Stratified Sampling", "KII & FGD", "APA 7th Referencing", "Participant Observation")
                ),
                com.example.data.model.TUCoursePaper(
                    courseCode = "SOC 426",
                    title = "Family, Marriage, Kinship & Demography in Nepal",
                    nepaliTitle = "परिवार, विवाह, नातागोता र जनसांख्यिकी (Paper VI)",
                    category = com.example.data.model.CourseCategory.SOCIOLOGY_MAJOR,
                    paperNumber = "Sociology Major Paper VI",
                    major = Subject.SOCIOLOGY,
                    description = "Marriage forms in Nepal (Monogamy, Fraternal Polyandry in Himalayas, Cross-Cousin marriage), kinship networks, joint to nuclear family shift, and demographic trends.",
                    units = listOf(
                        "Unit 1: Concepts of Family, Marriage & Kinship: Structural-Functional & Feminist Views",
                        "Unit 2: Forms of Marriage in Nepal: Arranged, Elopement, Fraternal Polyandry & Inter-Caste Marriage",
                        "Unit 3: Kinship Systems: Descent Rules (Patrilineal vs Matrilineal), Clan (*Kul*) & Guthi Networks",
                        "Unit 4: Transition from Joint (*Samyukta*) to Nuclear (*Ekak*) Families in Urban/Rural Nepal",
                        "Unit 5: Demographic Trends in Nepal: Fertility, Mortality, Urbanization & Census 2078 Findings"
                    ),
                    keyThinkersOrActs = listOf("Fraternal Polyandry in Humla", "National Population Census 2078", "Civil Code 2074", "Nuclear Family Shift")
                )
            ),
            keyObjectives = listOf(
                "Design LogFrame matrices and apply PRA field tools (RD 425)",
                "Analyze Cooperative Act 2074 and rural microfinance systems (RD 426)",
                "Master qualitative and quantitative social research techniques (SOC 425)",
                "Evaluate changing marriage forms, kinship, and Census 2078 demography (SOC 426)",
                "Gain comprehensive knowledge of Nepal's geography, history and geopolitics (C.NepSt 403)"
            )
        ),

        // ======================== BA 4TH YEAR (5 SUBJECTS) ========================
        com.example.data.model.TUYearSyllabus(
            yearNumber = 4,
            yearLabel = "BA 4th Year (5 Subjects • 500 Full Marks)",
            subtitle = "Applied Research, GESI, Remittances & Academic Monograph",
            description = "In BA 4th Year, students complete 5 papers (500 Marks): 2 Rural Development papers (GESI & Rural Practicum), 2 Sociology papers (Globalization/Remittances & Academic Thesis), and Academic Writing.",
            papers = listOf(
                com.example.data.model.TUCoursePaper(
                    courseCode = "C.Eng. 404",
                    title = "Academic Writing & Applied Social Research",
                    nepaliTitle = "प्राज्ञिक लेखन तथा व्यावहारिक सामाजिक अनुसन्धान",
                    category = com.example.data.model.CourseCategory.COMPULSORY,
                    paperNumber = "Compulsory Paper",
                    major = Subject.COMPULSORY_LANGUAGE,
                    description = "Advanced academic writing, literature review synthesis, research proposal formulation, drafting scholarly articles, and defending academic monographs.",
                    units = listOf(
                        "Unit 1: Structure of Academic Research Papers: Title, Abstract, Introduction, Methodology, Findings",
                        "Unit 2: Literature Review Synthesis & Thematic Gap Identification",
                        "Unit 3: Academic Voice, Hedging, Coherence & Formal Research Vocabulary",
                        "Unit 4: Citation Standards, Plagiarism Prevention & Referencing Software (Zotero/Mendeley)",
                        "Unit 5: Proposal Presentation, Defense Strategies & Manuscript Preparation"
                    ),
                    keyThinkersOrActs = listOf("Literature Synthesis", "Research Proposal", "APA 7th Style", "Academic Ethics")
                ),
                com.example.data.model.TUCoursePaper(
                    courseCode = "RD 427",
                    title = "Gender, Social Inclusion (GESI) & Human Development in Nepal",
                    nepaliTitle = "लैंगिक समानता, सामाजिक समावेशीकरण र मानव विकास (Paper VII)",
                    category = com.example.data.model.CourseCategory.RURAL_DEVELOPMENT_MAJOR,
                    paperNumber = "RD Major Paper VII",
                    major = Subject.RURAL_DEVELOPMENT,
                    description = "WID, WAD, GAD paradigms, Gender Responsive Budgeting (GRB) in Nepal's local governments, Human Development Index (HDI), and LDC graduation by 2026.",
                    units = listOf(
                        "Unit 1: Evolution of Gender Paradigms: Women in Development (WID) to Gender and Development (GAD)",
                        "Unit 2: Gender Responsive Budgeting (GRB) in Federal, Provincial & Local Budgets in Nepal",
                        "Unit 3: Social Inclusion Frameworks: Dalits, Adivasi Janajatis, Madhesis, Muslims & PwDs",
                        "Unit 4: Human Development Paradigm: HDI, Gender Inequality Index (GII) & MPI in Nepal",
                        "Unit 5: Nepal's Graduation from Least Developed Country (LDC) Status & 16th Periodic Plan"
                    ),
                    keyThinkersOrActs = listOf("Gender Responsive Budgeting", "LDC Graduation 2026", "16th Periodic Plan", "HDI & GII Indices")
                ),
                com.example.data.model.TUCoursePaper(
                    courseCode = "RD 428",
                    title = "Rural Practicum, Field Internship & Project Monograph",
                    nepaliTitle = "ग्रामीण प्रयोगात्मक कार्य तथा स्थलगत प्रतिवेदन (Paper VIII)",
                    category = com.example.data.model.CourseCategory.PRACTICUM_RESEARCH,
                    paperNumber = "RD Major Paper VIII (Practicum)",
                    major = Subject.RURAL_DEVELOPMENT,
                    description = "Mandatory 30-day field placement in a Rural Municipality (Gaunpalika), institutional study, community project formulation, and submitted monograph with viva-voce defense.",
                    units = listOf(
                        "Unit 1: Preparation for Rural Fieldwork: Objectives, Checklists & Palika Coordination",
                        "Unit 2: Institutional Study of Rural Municipality Executive, Ward Office & User Committees",
                        "Unit 3: Application of PRA Tools in Village Community & Problem Tree Analysis",
                        "Unit 4: Formulation of Mini Community Project Plan & Budget Estimation",
                        "Unit 5: Final Field Report Writing, Submission & External Viva-Voce Defense"
                    ),
                    keyThinkersOrActs = listOf("Palika Field Practicum", "Problem Tree Analysis", "Viva-Voce Defense", "Institutional Field Report")
                ),
                com.example.data.model.TUCoursePaper(
                    courseCode = "SOC 427",
                    title = "Sociology of Globalization, Transnational Migration & Remittances in Nepal",
                    nepaliTitle = "भूमण्डलीकरण, वैदेशिक रोजगारी र विप्रेषणको समाजशास्त्र (Paper VII)",
                    category = com.example.data.model.CourseCategory.SOCIOLOGY_MAJOR,
                    paperNumber = "Sociology Major Paper VII",
                    major = Subject.SOCIOLOGY,
                    description = "Transnational migration to Gulf/East Asia, remittance contribution to GDP (~25-30%), de-facto female headship, left-behind elderly, and cultural transformations.",
                    units = listOf(
                        "Unit 1: Globalization Theories: Economic, Cultural & Political Dimensions (Robertson, Giddens, Appadurai)",
                        "Unit 2: Trends and Drivers of Labor Outmigration from Nepal (Gulf, Malaysia, East Asia)",
                        "Unit 3: Economic vs Social Remittances (Ideas, Gender Norms, Political Consciousness)",
                        "Unit 4: Transformation of Rural Families: De-Facto Female Headship & Left-Behind Care Deficits",
                        "Unit 5: Reconfiguration of Rural Prestige, Feudal Hierarchy & Dutch Disease Risks in Nepal"
                    ),
                    keyThinkersOrActs = listOf("Transnationalism", "Social Remittances", "De-facto Female Headship", "Left-Behind Population")
                ),
                com.example.data.model.TUCoursePaper(
                    courseCode = "SOC 428",
                    title = "Academic Thesis / Research Monograph in Sociology",
                    nepaliTitle = "समाजशास्त्रमा शोधपत्र / अनुसन्धान मोनोग्राफ (Paper VIII)",
                    category = com.example.data.model.CourseCategory.PRACTICUM_RESEARCH,
                    paperNumber = "Sociology Major Paper VIII (Thesis)",
                    major = Subject.SOCIOLOGY,
                    description = "Independent empirical sociological investigation in a selected community, field data collection, theoretical analysis, thesis submission, and academic defense.",
                    units = listOf(
                        "Unit 1: Selection of Sociological Problem, Theoretical Orientation & Proposal Writing",
                        "Unit 2: Fieldwork Execution: Ethics, Informed Consent & Primary Data Collection",
                        "Unit 3: Qualitative / Quantitative Data Analysis & Sociological Interpretation",
                        "Unit 4: Chapterization: Introduction, Review, Methods, Findings, Analysis & Conclusion",
                        "Unit 5: Thesis Defense (Viva-Voce) before Department Examination Board"
                    ),
                    keyThinkersOrActs = listOf("Sociological Monograph", "Primary Fieldwork", "Thesis Defense", "Department Viva-Voce")
                )
            ),
            keyObjectives = listOf(
                "Apply GESI framework and Gender Responsive Budgeting in Palikas (RD 427)",
                "Complete 30-day rural field placement and submit practicum report (RD 428)",
                "Analyze transnational migration and sociological remittance impacts (SOC 427)",
                "Conduct independent empirical research and defend sociology thesis (SOC 428)",
                "Master scholarly academic writing, citation and proposal presentation (C.Eng 404)"
            )
        )
    )

    // ======================== BILINGUAL GLOSSARY (ENGLISH ⇄ NEPALI) ========================
    val bilingualGlossary: List<com.example.data.model.BilingualGlossaryItem> = listOf(
        com.example.data.model.BilingualGlossaryItem(
            id = "term_01",
            englishTerm = "Social Stratification",
            nepaliTerm = "सामाजिक स्तरीकरण (Samajik Starikaran)",
            subject = Subject.SOCIOLOGY,
            courseCode = "SOC 421",
            definitionEnglish = "Hierarchical arrangement of individuals and groups in a society based on wealth, power, caste, gender, or prestige.",
            definitionNepali = "समाजमा शक्ति, सम्पत्ति, जात वा प्रतिष्ठाका आधारमा गरिने तहगत वा श्रेणीगत विभाजन।",
            examExample = "Used in SOC 421 to explain Caste System (Varna hierarchy) vs Class dynamics in Nepal."
        ),
        com.example.data.model.BilingualGlossaryItem(
            id = "term_02",
            englishTerm = "Participatory Rural Appraisal (PRA)",
            nepaliTerm = "सहभागितामूलक ग्रामीण लेखाजोखा (PRA विधि)",
            subject = Subject.RURAL_DEVELOPMENT,
            courseCode = "RD 421",
            definitionEnglish = "Bottom-up qualitative research approach enabling rural local people to share, enhance, and analyze their knowledge of life conditions.",
            definitionNepali = "ग्रामीण जनता आफैँले आफ्नो समस्या, स्रोत र सम्भावनाको पहिचान तथा विश्लेषण गर्ने तल्लो तहको अनुसन्धान विधि।",
            examExample = "Key PRA tools: Social Mapping, Transect Walk, Venn Diagram, Seasonal Calendar."
        ),
        com.example.data.model.BilingualGlossaryItem(
            id = "term_03",
            englishTerm = "Decentralization & Deconcentration",
            nepaliTerm = "विकेन्द्रीकरण र कार्य विकेन्द्रीकरण",
            subject = Subject.RURAL_DEVELOPMENT,
            courseCode = "RD 422",
            definitionEnglish = "Transfer of authority, responsibility, and financial resources from central government to elected local tiers (Palikas/Wards).",
            definitionNepali = "केन्द्रीय सरकारको प्रशासनिक, योजनागत तथा वित्तीय अधिकार स्थानीय तहमा हस्तान्तरण गर्ने प्रक्रिया।",
            examExample = "Mandated by Local Government Operation Act 2074 (स्थानीय सरकार सञ्चालन ऐन २०७४)."
        ),
        com.example.data.model.BilingualGlossaryItem(
            id = "term_04",
            englishTerm = "Mechanical vs Organic Solidarity",
            nepaliTerm = "यान्त्रिक ऐक्यबद्धता विरुद्ध जैविक ऐक्यबद्धता",
            subject = Subject.SOCIOLOGY,
            courseCode = "SOC 423",
            definitionEnglish = "Émile Durkheim's theory: Mechanical (traditional society based on likeness) vs Organic (modern industrial society based on division of labor).",
            definitionNepali = "एमिल दुर्खिमको सिद्धान्त: परम्परागत समानतामा आधारित यान्त्रिक र आधुनिक श्रम विभाजनमा आधारित जैविक एकता।",
            examExample = "High-frequency 10-mark question in SOC 423 Classical Sociological Thought."
        ),
        com.example.data.model.BilingualGlossaryItem(
            id = "term_05",
            englishTerm = "Triangulation in Research",
            nepaliTerm = "अनुसन्धानमा त्रिकोणीकरण (Triangulation)",
            subject = Subject.RURAL_DEVELOPMENT,
            courseCode = "RD 426",
            definitionEnglish = "Using multiple methods, data sources, or theoretical perspectives to enhance the validity and credibility of research findings.",
            definitionNepali = "अनुसन्धानको विश्वसनीयता र वैधता पुष्टि गर्न बहुपक्षीय विधि तथा तथ्यांक स्रोतहरूको संयुक्त प्रयोग।",
            examExample = "Combining Quantitative Survey + Qualitative Key Informant Interviews (KII)."
        ),
        com.example.data.model.BilingualGlossaryItem(
            id = "term_06",
            englishTerm = "Social Remittances",
            nepaliTerm = "सामाजिक विप्रेषण (विचार, सीप र चेतना)",
            subject = Subject.SOCIOLOGY,
            courseCode = "SOC 427",
            definitionEnglish = "Non-monetary flows: ideas, behaviors, gender attitudes, entrepreneurial skills, and political values brought home by migrant workers (Peggy Levitt).",
            definitionNepali = "वैदेशिक रोजगारीबाट फर्किएका व्यक्तिहरूले स्वदेश भित्र्याउने नयाँ सोच, सीप, लैंगिक चेतना र कार्यशैली।",
            examExample = "Crucial for analyzing social transformations in rural Hill/Terai villages of Nepal."
        ),
        com.example.data.model.BilingualGlossaryItem(
            id = "term_07",
            englishTerm = "Gender Responsive Budgeting (GRB)",
            nepaliTerm = "लैङ्गिक उत्तरदायी बजेटिङ",
            subject = Subject.RURAL_DEVELOPMENT,
            courseCode = "RD 427",
            definitionEnglish = "Fiscal strategy allocating public resources to address gender inequalities and directly empower women and marginalized social groups.",
            definitionNepali = "राज्यको बजेट तथा योजनामा महिला तथा सिमान्तकृत वर्गको प्रत्यक्ष सहभागिता र लाभ सुनिश्चित गर्ने बजेट प्रणाली।",
            examExample = "Directly tested in TU 4th Year RD 427 Gender and Development."
        )
    )

    // ======================== 24-HOUR EMERGENCY HIGH-YIELD CHEAT SHEETS ========================
    val emergencyCheats: List<com.example.data.model.HighYieldEmergencyCheat> = listOf(
        com.example.data.model.HighYieldEmergencyCheat(
            id = "emg_01",
            courseCode = "RD 421",
            subject = Subject.RURAL_DEVELOPMENT,
            title = "Theories of Rural Development & Rostow's Growth Model",
            nepaliTitle = "ग्रामीण विकासका सिद्धान्त र रोस्टोको चरणबद्ध मोडल",
            highFrequencyQuestion = "Explain Rostow's 5 Stages of Economic Growth and critically assess its applicability in Nepal's rural economy.",
            tuYearsAsked = "TU Board 2073, 2076, 2079, 2081 (Repeated 4 times)",
            coreFormulaOrThinker = "W.W. Rostow (1960): Traditional → Pre-conditions → Take-off → Drive to Maturity → High Mass Consumption.",
            nepalActOrData = "Nepal currently in Transition from Pre-conditions to Take-off; constrained by infrastructure deficit & remittance dependency.",
            quickMemoryPoints = listOf(
                "Traditional Society: Subsistence agriculture, low tech, clan hierarchy.",
                "Take-off stage: Investment rate rises >10% of GDP, leading manufacturing sectors emerge.",
                "Limitation in Nepal: High remittance (27% GDP) driving imports rather than domestic agro-industrial manufacturing base.",
                "Exam Tip: Draw 5-step upward staircase diagram for 10/10 marks in Group B/C."
            )
        ),
        com.example.data.model.HighYieldEmergencyCheat(
            id = "emg_02",
            courseCode = "SOC 421",
            subject = Subject.SOCIOLOGY,
            title = "Functionalism vs Conflict Theory & Nepalese Social Structure",
            nepaliTitle = "प्रकार्यवादी र द्वन्द्ववादी दृष्टिकोण तथा नेपाली सामाजिक संरचना",
            highFrequencyQuestion = "Compare and contrast Functionalist and Conflict perspectives on social stratification with examples from Nepalese society.",
            tuYearsAsked = "TU Board 2074, 2077, 2080 (Repeated 3 times)",
            coreFormulaOrThinker = "Functionalism (Parsons, Davis-Moore): Stratification is necessary for functional order. Conflict (Marx, Weber): Stratification produces exploitation and inequality.",
            nepalActOrData = "Constitution of Nepal Article 18 (Right to Equality), Article 40 (Rights of Dalits), Article 42 (Right to Social Justice).",
            quickMemoryPoints = listOf(
                "Functionalist view: High rewards attract talented people to crucial positions (Doctors, Engineers).",
                "Conflict view: Dominant caste/class monopolizes state resources, reproducing generational poverty.",
                "Nepal Synthesis: Caste-based Muluki Ain (1854) historically institutionalized inequality; 2072 Constitution establishes proportional inclusion.",
                "Exam Tip: Provide comparison table with 5 rows (Theorist, Core Focus, View on Inequality, Social Change, Nepal Case)."
            )
        ),
        com.example.data.model.HighYieldEmergencyCheat(
            id = "emg_03",
            courseCode = "RD 422",
            subject = Subject.RURAL_DEVELOPMENT,
            title = "Agrarian Structure, Land Reform & Guthi System in Nepal",
            nepaliTitle = "नेपालको भूमिसुधार, कृषि संरचना र गुठी व्यवस्था",
            highFrequencyQuestion = "Examine the challenges of land fragmentation in Nepal and evaluate the effectiveness of Land Reform Act 2021.",
            tuYearsAsked = "TU Board 2075, 2078, 2081",
            coreFormulaOrThinker = "M.C. Regmi (Land Tenure and Taxation in Nepal): Birta, Jagir, Rikar, Kipat, and Guthi tenurial systems.",
            nepalActOrData = "Land Reform Act 2021 (Bhumisudhar Ain), 16th Periodic Plan target on land consolidation and cooperative farming.",
            quickMemoryPoints = listOf(
                "5 Historical Land Tenures: Raikar (State), Birta (Royal gift), Jagir (Salary), Kipat (Customary Rai/Limbu), Guthi (Religious trust).",
                "Land Fragmentation: Inheritance laws divide parcels into unviable plots (<0.5 ha average).",
                "Feminization of Agriculture: Male outmigration leaves women farming without formal land ownership deeds (Lalpurja).",
                "Way Forward: Land pooling, contract farming, cooperative modern mechanization."
            )
        ),
        com.example.data.model.HighYieldEmergencyCheat(
            id = "emg_04",
            courseCode = "SOC 423",
            subject = Subject.SOCIOLOGY,
            title = "Karl Marx: Historical Materialism, Base & Superstructure",
            nepaliTitle = "कार्ल मार्क्स: ऐतिहासिक भौतिकवाद, आधार र अधिरचना",
            highFrequencyQuestion = "Explain Karl Marx's theory of Historical Materialism and discuss how economic base determines legal-cultural superstructure.",
            tuYearsAsked = "TU Board 2073, 2076, 2079",
            coreFormulaOrThinker = "Economic Base (Forces + Relations of Production) → Superstructure (State, Law, Religion, Ideology).",
            nepalActOrData = "Feudal land relations in Terai/Hills (Zamindari system) historically determined political power distribution in Kathmandu.",
            quickMemoryPoints = listOf(
                "5 Historical Epochs: Primitive Communism → Ancient Slave Society → Feudalism → Capitalism → Socialism/Communism.",
                "Alienation (४ प्रकारको अलगाव): From product, process of labor, species-essence, and fellow workers.",
                "Class Struggle: 'The history of all hitherto existing society is the history of class struggles.'",
                "Exam Tip: Draw the 2-tier Base-Superstructure rectangular diagram."
            )
        ),
        com.example.data.model.HighYieldEmergencyCheat(
            id = "emg_05",
            courseCode = "RD 425",
            subject = Subject.RURAL_DEVELOPMENT,
            title = "Local Level Planning Process (7-Step Model in Palikas)",
            nepaliTitle = "स्थानीय तहको ७-चरणे योजना तर्जुमा प्रक्रिया",
            highFrequencyQuestion = "Describe the 7-step local level planning process under the Local Government Operation Act 2074 with flowchart.",
            tuYearsAsked = "TU Board 2077, 2079, 2081",
            coreFormulaOrThinker = "Ministry of Federal Affairs and General Administration (MoFAGA) 7-Stage Bottom-Up Planning Guideline.",
            nepalActOrData = "Local Government Operation Act 2074 (Section 24 on participatory planning).",
            quickMemoryPoints = listOf(
                "Step 1 (Chaitra): Resource estimation and budget ceiling determination.",
                "Step 2 (Baisakh): Settlement/Tole level project identification & prioritizing.",
                "Step 3 (Jestha): Ward Committee project screening and assembly submission.",
                "Step 4 (Jestha end): Sectoral Committee scrutiny (Infrastructure, Social, Economic, Environment, Governance).",
                "Step 5 (Ashadh 1-10): Executive Municipal Committee budget compilation.",
                "Step 6 (Ashadh 10): Presentation in Municipal Assembly (Gau/Nagar Sabha).",
                "Step 7 (Ashadh end): Approval, authorization and publication of Annual Plan."
            )
        )
    )
}
