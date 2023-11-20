module parity_matrix(u,y,c);
input [2:0]u;
input [3:0]y;
output [3:0]c;
assign c= (u[0]*y);
endmodule