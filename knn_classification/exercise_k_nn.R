library(class)
library(kknn)


values <- function(f,col1,col_two,col3){
  
  f[[col1]] <- f[[col_two]] * f[[col3]]
  
  return(f)
  
}


values_differ <- function(f,col_one,col_two,col_three){
  
  f[[col_one]] <- f[[col_two]] - f[[col_three]]
  
  return(f)
  
}



file_knn <- read.csv("C:\\Users\\adith\\Documents\\thinkstats\\Rprogramming\\k_nn_exercise\\k_nn_exercise.csv")


#cchecking for null values in each column
print(apply(file_knn, 2, function(x) sum(is.na(x))))

#column names
colnames(file_knn) <- c("class","left_weight","left_distance","right_weight","right_distance")



print(unique(file_knn$class))

#creating new columns
file_knn$left_product <- 0
file_knn$right_product <- 0
file_knn$difference <- 0



file_knn <- values(file_knn,"left_product","left_weight","left_distance")
file_knn <- values(file_knn,"right_product","right_distance","right_weight")
file_knn <- values_differ(file_knn,"difference","right_product","left_product")


SEED <- 123
set.seed(SEED)
data <- file_knn[sample(nrow(file_knn)), ]
x <- floor(0.7 * nrow(data))
trainig_set <- data[1:x,]
test_set <- data[(x+1):nrow(data),]


X_train <- subset(trainig_set, select=-class)
y_train <- trainig_set$class
X_test <- subset(test_set, select=-class) # exclude Class for prediction
y_test <- test_set$class

model_knn <- knn(train=X_train,
                 test=X_test,
                 cl=y_train,  # class labels
                 k=3)
conf_mat <- table(y_test, model_knn)
print(conf_mat)
cat("accuracy is given by ",sum(diag(conf_mat))/sum(conf_mat))

file_knn_school <- read.csv("C:\\Users\\adith\\Documents\\thinkstats\\Rprogramming\\k_nn_exercise_2.csv")

#str(file_knn_school)

files.sub <- subset(file_knn_school, select=c(name, province.name..english, latitude, longitude))

#cchecking for null values in each column
print(apply(files.sub, 2, function(x) sum(is.na(x))))



colnames(files.sub)<- c("name","province","latitude","longitude")


print(head(files.sub))




set.seed(123)
indice <- sample(2, nrow(files.sub), replace=TRUE, prob=c(0.7, 0.3)) # This creates a vector of equal length to our data, with approximately 70% of the values being 1 and the remaining values are 2  
# Create training and test sets containing only the geographical locations 
#X_train_school <- trainig_set_school[ , c("latitude","longitude")]
X_train_school <- files.sub[indice ==1, c("latitude","longitude")]
X_test_school <- files.sub[indice ==2, c("latitude","longitude")]
# Note: Normalizing or standardizing the geographical attributes of the data will not be helpful since values are already on the same scale 
# Create the target vectors for the training and test data from the original dataset using ind
y_train_school <- files.sub[indice ==1,c("province")]
y_test_province <- files.sub[indice ==2,c("province")]
# Run the knn algorithm to classify test data points into the different provinces
knn_school <- knn(train = X_train_school, test = X_test_school, cl = y_train_school, k=3)

correct_classification <- which(knn_school == y_test_province)


proportion_of_correct_provinces <- length(correct_classification)/length(y_test_province)
cat("Accuracy", proportion_of_correct_provinces,"\n")

#conf_mat_school <- (table((y_test_school), model_knn_school))
#print(conf_mat_school)
#cat("accuracy is given by ",sum(diag(conf_mat_school))/sum(conf_mat_school))




















