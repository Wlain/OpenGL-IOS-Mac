///////////////////////////////////////////////////////////
//attribute
attribute vec4 a_position;
attribute vec4 a_texCoord;
attribute vec4 a_normal;

///////////////////////////////////////////////////////////
//uniform
uniform mat4 u_modelMatrix;
uniform mat4 u_viewMatrix;
uniform mat4 u_projectionMatrix;
uniform mat4 u_normalMatrix;
uniform vec4 u_lightPosition;

///////////////////////////////////////////////////////////
//varying
varying vec2 v_texCoord;
varying vec3 v_normal;
varying vec3 v_worldPosition;
varying float v_lightDistance;

void main(void) {
    v_normal = normalize(mat3(u_normalMatrix) * a_normal.xyz);
    v_worldPosition = (u_modelMatrix * a_position).xyz;
    v_lightDistance = length(u_lightPosition.xyz - v_worldPosition.xyz);
    v_texCoord = a_texCoord.st;
    gl_Position = u_projectionMatrix * u_viewMatrix * u_modelMatrix * a_position;
}


