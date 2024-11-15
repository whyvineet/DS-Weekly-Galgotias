#include <stdio.h>
#include <string.h>
#include <ctype.h>

int isDecimalNumber(char* s) {
    int len = strlen(s);
    int i = 0;
    int dotSeen = 0;
    int eSeen = 0;
    int numberSeen = 0;
    int numberAfterE = 0;
    
    while (i < len && s[i] == ' ') i++;
    
    if (i < len && (s[i] == '+' || s[i] == '-')) i++;
    
    while (i < len) {
        if (isdigit(s[i])) {
            numberSeen = 1;
            if (eSeen) numberAfterE = 1;
        }
        else if (s[i] == '.') {
            if (eSeen || dotSeen) return 0;
            dotSeen = 1;
        }
        else if (s[i] == 'e' || s[i] == 'E') {
            if (eSeen || !numberSeen) return 0;
            eSeen = 1;
            if (i + 1 < len && (s[i + 1] == '+' || s[i + 1] == '-')) i++;
        }
        else if (s[i] == ' ') {
            int j = i + 1;
            while (j < len && s[j] == ' ') j++;
            if (j == len) break;
            return 0;
        }
        else {
            return 0;
        }
        i++;
    }
    
    return numberSeen && (!eSeen || numberAfterE);
}

int main() {
    char input[1000];
    fgets(input, sizeof(input), stdin);
    
    int len = strlen(input);
    if (len > 0 && input[len-1] == '\n') {
        input[len-1] = '\0';
    }
    
    printf("%d\n", isDecimalNumber(input));
    return 0;
}