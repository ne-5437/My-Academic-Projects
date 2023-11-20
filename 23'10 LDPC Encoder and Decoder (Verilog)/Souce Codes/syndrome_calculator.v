module syndrome_calculation(h1,h2,h3,c,o);
input [5:0]h1,h2,h3,c;
output [2:0]o;
assign o[0]=(c[0]*h1[0])+(c[1]*h1[1])+(c[2]*h1[2])+(c[3]*h1[3])+(c[4]*h1[4])+(c[5]*h1[5]);
assign o[1]=(c[0]*h2[0])+(c[1]*h2[1])+(c[2]*h2[2])+(c[3]*h2[3])+(c[4]*h2[4])+(c[5]*h2[5]);
assign o[2]=(c[0]*h3[0])+(c[1]*h3[1])+(c[2]*h3[2])+(c[3]*h3[3])+(c[4]*h3[4])+(c[5]*h3[5]);
endmodule
  
  
   
