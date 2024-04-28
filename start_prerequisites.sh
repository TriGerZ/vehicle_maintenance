#java -cp h2-2.2.224.jar org.h2.tools.Shell
# -> jdbc:h2:~/data/db
java -cp h2-2.2.224.jar org.h2.tools.Server -webAllowOthers -tcpAllowOthers &
