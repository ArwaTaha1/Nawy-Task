Select c.name, max(r.ranking), count(s.id) 
from colleges c, students s, rankings r where year = 2015 
and c.id = s.collegeId and r.studentId = s.id and r.ranking between 1 and 3 group by c.name ;